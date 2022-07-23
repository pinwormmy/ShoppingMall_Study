package com.pinwormmy.mall.product;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Resource(name = "uploadPath")
	private String uploadPath;

	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct() {

		return "addProduct";
	}

	@RequestMapping(value = "/modifyProduct", method = RequestMethod.GET)
	public String modifyProduct(ProductDTO productDTO, Model model) throws Exception {

		productDTO = productService.productDetails(productDTO);
		model.addAttribute("product", productDTO);

		return "modifyProduct";
	}

	@RequestMapping(value = "/submitModifyProduct", method = RequestMethod.POST)
	public String submitModifyProduct(ProductDTO productDTO, MultipartFile file, HttpServletRequest request) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "img";
		String ymdPath = ThumbnailController.calcPath(imgUploadPath);
		String fileName = null;

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {		
			new File(uploadPath + request.getParameter("thumbnailPath")).delete();			
			fileName = ThumbnailController.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);			
			productDTO.setThumbnailPath(File.separator + "img" + ymdPath + File.separator + fileName);
		} else {					
			productDTO.setThumbnailPath(request.getParameter("thumbnailPath"));
		}		

		productService.submitModifyProduct(productDTO);

		return "redirect:/productDetails?productNum=" + productDTO.getProductNum();
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct(ProductDTO productDTO) throws Exception {

		productService.deleteProduct(productDTO);

		return "redirect:/";
	}

	@RequestMapping(value = "/submitProduct", method = RequestMethod.POST)
	public String submitProduct(ProductDTO productDTO, MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "img";
		String ymdPath = ThumbnailController.calcPath(imgUploadPath);
		String fileName = null;

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {			
			fileName = ThumbnailController.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);			
			productDTO.setThumbnailPath(File.separator + "img" + ymdPath + File.separator + fileName);
		} else {			
			fileName = File.separator + "img" + File.separator + "none.jpg";
			productDTO.setThumbnailPath(fileName);
		}		
		
		productService.submitProduct(productDTO);

		return "redirect:/";
	}

	@RequestMapping(value = "/productDetails", method = RequestMethod.GET)
	public String productDetails(ProductDTO productDTO, Model model) throws Exception {

		productDTO = productService.productDetails(productDTO);
		model.addAttribute("product", productDTO);

		return "productDetails";
	}
	
	

}
