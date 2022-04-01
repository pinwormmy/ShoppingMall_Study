package com.pinwormmy.mall.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.pinwormmy.mall.dto.ProductDTO;
import com.pinwormmy.mall.service.ProductService;

import net.coobird.thumbnailator.Thumbnails;

@Controller
public class EditorController {
	
	@Autowired
	private ProductService productService;
	
	// 이미지 업로드
    @RequestMapping(value="ckUpload/imageUpload.do", method = RequestMethod.POST)
    public void imageUpload(HttpServletRequest request,
    		HttpServletResponse response, MultipartHttpServletRequest multiFile
    		, @RequestParam MultipartFile upload, ProductDTO productDTO) throws Exception{
    	
    	// 랜덤 문자 생성
    	UUID uid = UUID.randomUUID();
    	
    	OutputStream out = null;
    	PrintWriter printWriter = null;
    	
    	//인코딩
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	
    	try{
    		//파일 이름 가져오기
    		String fileName = upload.getOriginalFilename();
    		byte[] bytes = upload.getBytes();
    		
    		//이미지 경로 생성
    		String path = "C:\\Users\\erl\\git\\ShoppingMall_Study\\ShoppingMall_Study\\src\\main\\webapp\\resources\\img/" ;
    		// String path = "C:\\Users\\erl\\Pictures" + "ckImage/";	// 이미지 경로 설정(폴더 자동 생성)
    		String ckUploadPath = path + uid + "_" + fileName;
    		String ckUploadPath_thumbnail = path + "thumbnail_" + fileName;
    		// String ckUploadPath_thumbnailLink = "/resources/img/" + "thumbnail_" + fileName;
    		
    		// productDTO.setThumbnailPath(ckUploadPath_thumbnailLink);   	
    		/*
    		System.out.println(productDTO.getProductNum());
    		System.out.println(productDTO.getProductName());
    		System.out.println("요지경 테스트" + productDTO.getThumbnailPath());
    		*/
    		File folder = new File(path);
    		System.out.println("path:" + path);	// 이미지 저장경로 console에 확인
    		
    		//해당 디렉토리 확인
    		if(!folder.exists()){
    			try{
    				folder.mkdirs(); // 폴더 생성
	    		}catch(Exception e){
	    			e.getStackTrace();
	    		}
    		}
    	
    		File uploadImage = new File(ckUploadPath);
	    	out = new FileOutputStream(uploadImage);
	    	out.write(bytes);
	    	out.flush(); // outputStram에 저장된 데이터를 전송하고 초기화
	    	out.close();
	    	/*
	    	// 썸네일 파일 만들기
	    	File thumbnail = new File(ckUploadPath_thumbnail);
	    	out = new FileOutputStream(thumbnail);
			Thumbnails.of(uploadImage).size(150, 150).toOutputStream(out);;
	    	out.flush(); // 썸넬 전송
	    	*/
	    	
	    	String callback = request.getParameter("CKEditorFuncNum");
	    	printWriter = response.getWriter();
	    	String fileUrl = "/ckUpload/ckImgSubmit.do?uid=" + uid + "&fileName=" + fileName; // 작성화면
	    	
	    	// 업로드시 메시지 출력
	    	printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
	    	printWriter.flush();
    	
    	}catch(IOException e){
    		e.printStackTrace();
    	} finally {
    		try {
    		if(out != null) { out.close(); }
    		if(printWriter != null) { printWriter.close(); }
    	} catch(IOException e) { e.printStackTrace(); }
    	}
    	return;
    }
    
    // 서버로 전송된 이미지 뿌려주기
    @RequestMapping(value="/ckUpload/ckImgSubmit.do")
    public void ckSubmit(@RequestParam(value="uid") String uid, @RequestParam(value="fileName") String fileName, 
    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	//서버에 저장된 이미지 경로
    	// String path = "C:\\Users\\erl\\Pictures" + "ckImage/";	// 저장된 이미지 경로
    	String path = "C:\\Users\\erl\\git\\ShoppingMall_Study\\ShoppingMall_Study\\src\\main\\webapp\\resources\\img/" ;
    	System.out.println("서버에 저장된 이미지 경로 :" + path);
    	String sDirPath = path + uid + "_" + fileName;
    	
    	File imgFile = new File(sDirPath);
    	    	
    	//사진 이미지 찾지 못하는 경우 예외처리로 빈 이미지 파일을 설정한다.
    	if(imgFile.isFile()){
    		byte[] buf = new byte[1024];
    		int readByte = 0;
    		int length = 0;
    		byte[] imgBuf = null;
    		
    		FileInputStream fileInputStream = null;
    		ByteArrayOutputStream outputStream = null;
    		ServletOutputStream out = null;
    		
    		try{
    			fileInputStream = new FileInputStream(imgFile);    			
    			outputStream = new ByteArrayOutputStream();
    			out = response.getOutputStream();
    			    			
    			while((readByte = fileInputStream.read(buf)) != -1){
    				outputStream.write(buf, 0, readByte); 
    			}
    			    			
    			imgBuf = outputStream.toByteArray();
    			length = imgBuf.length;
    			out.write(imgBuf, 0, length);
    			out.flush();
    			
    		}catch(IOException e){
    			e.printStackTrace();
    		}finally {
    			outputStream.close();
    			fileInputStream.close();
    			out.close();
    		}
    	}
    	
    }

}
