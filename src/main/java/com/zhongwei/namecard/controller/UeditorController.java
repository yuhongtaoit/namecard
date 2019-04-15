package com.zhongwei.namecard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.zhongwei.namecard.common.Ueditor;
import com.zhongwei.namecard.service.FileUploadService;
import com.zhongwei.namecard.utils.PublicMsg;

@Controller
@Transactional
public class UeditorController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/config")
	@ResponseBody
	public String getConfigInfo(HttpServletRequest request,HttpServletResponse response){
		return PublicMsg.UEDITOR_CONFIG;
	}
	
	@RequestMapping("/uploadImageData")
	@ResponseBody
	public String uploadImageData(HttpServletRequest request) {
	    Gson gson = new Gson();
	    Ueditor msg = uploadFile(request);
	    return gson.toJson(msg);
	}

	private Ueditor uploadFile(HttpServletRequest request) {
	    Ueditor image = new Ueditor();
	    List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("upfile");
	    String fileName = files.get(0).getOriginalFilename();
		String path = fileUploadService.uploadForSingleFile(request, null, files.get(0));
		image.setUrl("/"+path);
		image.setState("SUCCESS");
		image.setOriginal(fileName);
		image.setTitle(fileName);
	    return image;
	}
}
