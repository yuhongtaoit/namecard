package com.zhongwei.namecard.service;

import java.io.File;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	@Value(value = "${file.basefilepath}")
	private String baseFilePath;//资源文件绝对地址目录
	
	public String uploadForSingleFile(HttpServletRequest request, HttpServletResponse response, MultipartFile file){
		return this.upload(file,request);
	}
	
	public List<String> uploadForMultiFile(HttpServletRequest request, HttpServletResponse response, MultipartFile[] files){
		List<String> resultPath = new ArrayList<String>();
		for(MultipartFile file : files) {
			String returnPath = this.upload(file,request);
			resultPath.add(returnPath);
		}
		return resultPath;
	}
	
	public boolean deleteFile(String filePath) {
		boolean flag = false;
		File tempFile = new File(baseFilePath,filePath);
		if (tempFile.isFile() && tempFile.exists()) {
			tempFile.delete();
			flag = true;
		}
	    return flag;
	}
	
	private String upload(MultipartFile file, HttpServletRequest request) {
		String returnPath="";
		Calendar calender = Calendar.getInstance();
		File filePath = new File(baseFilePath);
		if (!filePath.exists() && !filePath.isDirectory()) {
		    System.out.println("目录不存在，创建目录：" + filePath);
		    filePath.mkdir();
		}
		String fileName = file.getOriginalFilename();
		String finalFileName = this.getUniFileName(fileName);
		returnPath = "attachment/images/"+calender.get(Calendar.YEAR)+"/"+(calender.get(Calendar.MONTH)+1)+"/"+calender.get(Calendar.DAY_OF_MONTH)+"/"+finalFileName;
		File tempFile = new File(filePath.getAbsolutePath(),returnPath);
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
