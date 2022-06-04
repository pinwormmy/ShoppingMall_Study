package com.pinwormmy.mall.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.service.ProductService;

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

	@RequestMapping(value = "/submitModifyProduct", method = RequestMethod.GET)
	public String submitModifyProduct(ProductDTO productDTO) throws Exception {

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

		System.out.printf("파일 잘 받아왔나? %s \n", file);
		System.out.printf("주소값은 잘 맞나? %s \n", uploadPath);

		String imgUploadPath = uploadPath + File.separator + "img";
		String ymdPath = ThumbnailController.calcPath(imgUploadPath);
		String fileName = null;

		System.out.printf("날짜값 제대로 받아왔나? : %s \n", ymdPath);

		if (file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			System.out.printf("파일 있는지 똑띠 확인했나??(있는경우) \n");
			fileName = ThumbnailController.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			System.out.printf("파일 업로드하고, 파일명 받아왔나? : %s \n", fileName);
			productDTO.setThumbnailPath(File.separator + "img" + ymdPath + File.separator + fileName);
		} else {
			System.out.printf("파일 있는지 똑띠 확인했나??(없는 경우) \n");
			fileName = File.separator + "img" + File.separator + "none.jpg";
			productDTO.setThumbnailPath(fileName);
		}

		System.out.printf("그래서 썸네일 파일 경로 똑띠 받았나? : %s \n", productDTO.getThumbnailPath());
		
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
