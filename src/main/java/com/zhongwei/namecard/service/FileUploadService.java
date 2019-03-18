package com.zhongwei.namecard.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public void upload(HttpServletRequest request, HttpServletResponse response, 
			MultipartFile logoimage, MultipartFile shareimage, MultipartFile style2bgimage,	MultipartFile[] personalimages){
		Date date = new Date();
		List<String> fileNameList = new ArrayList<>();
		fileNameList.add(logoimage.getOriginalFilename());
		fileNameList.add(shareimage.getOriginalFilename());
		fileNameList.add(style2bgimage.getOriginalFilename());
		for(MultipartFile personalImage : personalimages) {
			fileNameList.add(personalImage.getOriginalFilename());
		}
        @SuppressWarnings("deprecation")
		String path=request.getSession().getServletContext().getRealPath("images/"+date.getYear()+"/"+date.getMonth()+"/"+date.getDay());
        for(String fileName : fileNameList) {
        	File tempFile = new File(path, date.getTime() + String.valueOf(fileName));
        	if (!tempFile.getParentFile().exists()) {
        		tempFile.getParentFile().mkdir();
        	}
        	if (!tempFile.exists()) {
        		try {
        			tempFile.createNewFile();
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        	}
        	try {
        		logoimage.transferTo(tempFile);
        	} catch (IllegalStateException | IOException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        }
	}

}
