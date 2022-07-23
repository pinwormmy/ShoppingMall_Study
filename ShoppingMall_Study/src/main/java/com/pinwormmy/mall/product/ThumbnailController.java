package com.pinwormmy.mall.product;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

// 근데 이걸 컨트롤러 두는게 맞냐? 리팩토링할때 정리좀해라

@Controller
public class ThumbnailController {

	static final int THUMB_WIDTH = 300;
	static final int THUMB_HEIGHT = 300;

	public static String fileUpload(String uploadPath, String fileName, byte[] fileData, String ymdPath)
			throws Exception {

		// 원본 따로 두지 않고 썸네일만 업로드하는 코드로 수정
		UUID uid = UUID.randomUUID();

		String newFileName = uid + "_" + fileName;
		String imgPath = uploadPath + ymdPath;
		File target = new File(imgPath, newFileName);
		FileCopyUtils.copy(fileData, target);
		File image = new File(imgPath + File.separator + newFileName);

		// File thumbnail = new File(imgPath + File.separator + "s" + File.separator + thumbFileName);

		if (image.exists()) {
			// thumbnail.getParentFile().mkdirs();
			Thumbnails.of(image).size(THUMB_WIDTH, THUMB_HEIGHT).toFile(image);
		}
		
		return newFileName;
	}

	public static String calcPath(String uploadPath) {
				
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath, yearPath, monthPath, datePath);

		return datePath;
	}

	private static void makeDir(String uploadPath, String... paths) {		
		
		if (new File(paths[paths.length - 1]).exists()) 
			return;		

		for (String path : paths) {
			File dirPath = 
					new File(uploadPath + path);
			if (!dirPath.exists()) 
				dirPath.mkdir();
		}
	}
}
