package com.zhongwei.namecard.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	public String uploadForSingleFile(HttpServletRequest request, HttpServletResponse response, MultipartFile file){
		return this.upload(file);
	}
	
	public List<String> uploadForMultiFile(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files){
		List<String> resultPath = new ArrayList<String>();
		for(MultipartFile file : files) {
			String returnPath = this.upload(file);
			resultPath.add(returnPath);
		}
		return resultPath;
	}
	
	public boolean deleteFile(String filePath) {
		boolean flag = false;
		try {
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			File tempFile = new File(path.getAbsolutePath(),"static/"+filePath);
			if (tempFile.isFile() && tempFile.exists()) {
				tempFile.delete();
				flag = true;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    return flag;
	}
	
	private String upload(MultipartFile file) {
		String returnPath="";
		try {
			Calendar calender = Calendar.getInstance();
			File path = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path.exists()) path = new File("");
			String fileName = file.getOriginalFilename();
			String finalFileName = this.getUniFileName(fileName);
			returnPath = "attachment/"+calender.get(Calendar.YEAR)+"/"+(calender.get(Calendar.MONTH)+1)+"/"+calender.get(Calendar.DAY_OF_MONTH)+"/"+finalFileName;
			File tempFile = new File(path.getAbsolutePath(),"static/"+returnPath);
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
			if (!tempFile.exists()) {
				try {
					tempFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				file.transferTo(tempFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return returnPath;
	}
	
	private String getUniFileName(String fileName) {
		int index = fileName.lastIndexOf(".");
        String toPrefix="";
        String toSuffix="";
        if(index==-1){
            toPrefix=fileName;
        }else{
            toPrefix=fileName.substring(0,index);
            toSuffix=fileName.substring(index,fileName.length());
        }
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String hashFileName = Md5Crypt.md5Crypt(toPrefix.getBytes());
		return format.format(new Date())+hashFileName.replace("/", "")+toSuffix;
		
	}

}
