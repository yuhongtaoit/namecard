package com.zhongwei.namecard.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zhongwei.namecard.common.CommonMessage;
import com.zhongwei.namecard.dao.CardAdvMapper;
import com.zhongwei.namecard.dao.CardNavMapper;
import com.zhongwei.namecard.dao.CardNewsMapper;
import com.zhongwei.namecard.dao.CardWebMapper;
import com.zhongwei.namecard.entity.CardAdv;
import com.zhongwei.namecard.entity.CardNav;
import com.zhongwei.namecard.entity.CardNews;
import com.zhongwei.namecard.entity.CardWeb;

@Service
public class WebSiteService {
	
	@Autowired
	private CardWebMapper cardWebMapper;
	
	@Autowired
	private CardAdvMapper cardAdvMapper;
	
	@Autowired
	private CardNavMapper cardNavMapper;
	
	@Autowired
	private CardNewsMapper cardNewsMapper;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Transactional
	public CommonMessage updateWebBasicSet(MultipartFile video, MultipartFile images, MultipartFile[] cpBsImage,
			HttpServletRequest request, HttpServletResponse response, CardWeb cardWeb, CardWeb oldCardWeb) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setWbeBasicSetDefaultValue(cardWeb);
			if(video==null && !StringUtils.isEmpty(cardWeb.getVideo())) {
				cardWeb.setVideo(oldCardWeb.getVideo());
			}else {
				this.fileUploadService.deleteFile(oldCardWeb.getVideo());
				cardWeb.setVideo(this.fileUploadService.uploadForSingleFile(request, response, video));
			}
			if(images==null && !StringUtils.isEmpty(cardWeb.getImages())) {
				cardWeb.setImages(oldCardWeb.getImages());
			}else {
				this.fileUploadService.deleteFile(oldCardWeb.getImages());
				cardWeb.setImages(this.fileUploadService.uploadForSingleFile(request, response, images));
			}
			List<String> cpBsList = Arrays.asList(this.toArray(cardWeb.getCpBsContent()));
			List<String> oldCpBsList = Arrays.asList(this.toArray(oldCardWeb.getCpBsContent()));
			if(cpBsImage==null || cpBsImage.length<=0) {
				this.removeNotExistFile(cpBsList, oldCpBsList);
			}else {
				List<String> newCpBsPaths = new ArrayList<String>();
				this.removeNotExistFile(cpBsList, oldCpBsList);
				List<String> newCpBsImagePaths = this.fileUploadService.uploadForMultiFile(request, response, cpBsImage);
				if(cpBsList!=null && cpBsList.size()>0) {
					for(String cpBs : cpBsList) {
						newCpBsPaths.add(cpBs);
					}
				}
				newCpBsPaths.addAll(newCpBsImagePaths);
				cardWeb.setCpBsContent(newCpBsPaths.toString());
			}
			this.cardWebMapper.updateByPrimaryKeyWithBLOBs(cardWeb);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

	@Transactional
	public CommonMessage createWebBasicSet(MultipartFile video, MultipartFile images, MultipartFile[] cpBsImage,
			HttpServletRequest request, HttpServletResponse response, CardWeb cardWeb) {
		CommonMessage message = new CommonMessage();
		String videoPath = fileUploadService.uploadForSingleFile(request, response, video);
		String imagesPath = fileUploadService.uploadForSingleFile(request, response, images);
		List<String> cpBsImagePaths = fileUploadService.uploadForMultiFile(request, response, cpBsImage);
		this.setWbeBasicSetDefaultValue(cardWeb);
		cardWeb.setCpBsContent(cpBsImagePaths.toString());
		cardWeb.setImages(imagesPath);
		cardWeb.setVideo(videoPath);
		try {
			cardWebMapper.insert(cardWeb);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(videoPath);
			fileUploadService.deleteFile(imagesPath);
			for(String cpBsPath : cpBsImagePaths) {
				fileUploadService.deleteFile(cpBsPath);
			}
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private String[] toArray(String value) {
		if(value.startsWith("[")) {
			return value.substring(value.indexOf("[")+1, value.lastIndexOf("]")).split(",");
		}else {
			return value.split(",");
		}
	}
	
	private List<String> removeNotExistFile(List<String> files,List<String> oldFiles) {
		for(String oldFile : oldFiles) {
			if(!files.contains(oldFile)) {
				this.fileUploadService.deleteFile(oldFile.trim());
			}
		}
		return files;
	}

	public CommonMessage updateAdv(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardAdv cardAdv, CardAdv oldCardAdv) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setAdvDefaultValue(cardAdv);
			if(gimage==null && !StringUtils.isEmpty(cardAdv.getImages())) {
				cardAdv.setImages(oldCardAdv.getImages());
			}else {
				this.fileUploadService.deleteFile(oldCardAdv.getImages());
				cardAdv.setImages(this.fileUploadService.uploadForSingleFile(request, response, gimage));
			}
			this.cardAdvMapper.updateByPrimaryKey(cardAdv);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

	public CommonMessage createAdv(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardAdv cardAdv) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String imagePath = fileUploadService.uploadForSingleFile(request, response, gimage);
		this.setAdvDefaultValue(cardAdv);
		cardAdv.setImages(imagePath);
		try {
			this.cardAdvMapper.insert(cardAdv);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(imagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private CardWeb setWbeBasicSetDefaultValue(CardWeb cardWeb) {
		cardWeb.setCpBsContent(cardWeb.getCpBsContent()==null?"":cardWeb.getCpBsContent());
		cardWeb.setImages(cardWeb.getImages()==null?"":cardWeb.getImages());
		cardWeb.setUniacid(cardWeb.getUniacid()==null?2:cardWeb.getUniacid());
		cardWeb.setVideo(cardWeb.getVideo()==null?"":cardWeb.getVideo());
		return cardWeb;
	}
	
	private CardAdv setAdvDefaultValue(CardAdv cardAdv) {
		cardAdv.setImages(cardAdv.getImages()==null?"":cardAdv.getImages());
		cardAdv.setUniacid(cardAdv.getUniacid()==null?2:cardAdv.getUniacid());
		return cardAdv;
	}

	public CommonMessage updateNav(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardNav cardNav, CardNav oldCardNav) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setNavDefaultValue(cardNav);
			if(gimage==null && !StringUtils.isEmpty(cardNav.getImages())) {
				cardNav.setImages(oldCardNav.getImages());
			}else {
				this.fileUploadService.deleteFile(oldCardNav.getImages());
				cardNav.setImages(this.fileUploadService.uploadForSingleFile(request, response, gimage));
			}
			this.cardNavMapper.updateByPrimaryKey(cardNav);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

	public CommonMessage createNav(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardNav cardNav) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String imagePath = fileUploadService.uploadForSingleFile(request, response, gimage);
		this.setNavDefaultValue(cardNav);
		cardNav.setImages(imagePath);
		try {
			this.cardNavMapper.insert(cardNav);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(imagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private CardNav setNavDefaultValue(CardNav cardNav) {
		cardNav.setAppid(cardNav.getAppid()==null?"":cardNav.getAppid());
		cardNav.setImages(cardNav.getImages()==null?"":cardNav.getImages());
		cardNav.setLinktype(cardNav.getLinktype()==null?"":cardNav.getLinktype());
		cardNav.setNewid(cardNav.getNewid()==null?"":cardNav.getNewid());
		cardNav.setPath(cardNav.getPath()==null?"":cardNav.getPath());
		cardNav.setPathWeb(cardNav.getPathWeb()==null?"":cardNav.getPathWeb());
		cardNav.setTitle(cardNav.getTitle()==null?"":cardNav.getTitle());
		cardNav.setUniacid(cardNav.getUniacid()==null?2:cardNav.getUniacid());
		return cardNav;
	}

	public CommonMessage updateNews(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardNews cardNews, CardNews oldCardNews) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		try {
			this.setNewsDefaultValue(cardNews);
			if(gimage==null && !StringUtils.isEmpty(cardNews.getHeadImg())) {
				cardNews.setHeadImg(oldCardNews.getHeadImg());
			}else {
				this.fileUploadService.deleteFile(oldCardNews.getHeadImg());
				cardNews.setHeadImg(this.fileUploadService.uploadForSingleFile(request, response, gimage));
			}
			this.cardNewsMapper.updateByPrimaryKeyWithBLOBs(cardNews);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}

	public CommonMessage createNews(MultipartFile gimage, HttpServletRequest request, HttpServletResponse response,
			CardNews cardNews) {
		// TODO Auto-generated method stub
		CommonMessage message = new CommonMessage();
		String imagePath = fileUploadService.uploadForSingleFile(request, response, gimage);
		this.setNewsDefaultValue(cardNews);
		cardNews.setHeadImg(imagePath);
		try {
			this.cardNewsMapper.insert(cardNews);
			message.setSuccess(true);
			message.setMessage("保存成功！");
			return message;
		} catch (Exception e) {
			fileUploadService.deleteFile(imagePath);
			message.setSuccess(false);
			message.setMessage("保存失败！");
			return message;
		}
	}
	
	private CardNews setNewsDefaultValue(CardNews cardNews) {
		cardNews.setContent(cardNews.getContent()==null?"":cardNews.getContent());
		cardNews.setHeadImg(cardNews.getHeadImg()==null?"":cardNews.getHeadImg());
		cardNews.setSort(cardNews.getSort()==null?0:cardNews.getSort());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		cardNews.setTime(cardNews.getTime()==null?0:cardNews.getTime());
		cardNews.setTimeStr(cardNews.getTimeStr()==null?sdf.format(new Date()):cardNews.getTimeStr());
		cardNews.setTitle(cardNews.getTitle()==null?"":cardNews.getTitle());
		cardNews.setUniacid(cardNews.getUniacid()==null?2:cardNews.getUniacid());
		return cardNews;
	}

}
