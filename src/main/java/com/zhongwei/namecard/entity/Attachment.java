package com.zhongwei.namecard.entity;

import java.io.Serializable;

public class Attachment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Integer uniacid;
	
	private Integer uid;
	
	private String filename;
	
	private String path;
	
	private String type;
	
	private Integer createTime;
	
	private String moduleUploadDir;
	
	private Integer groupId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUniacid() {
		return uniacid;
	}
	public void setUniacid(Integer uniacid) {
		this.uniacid = uniacid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getModuleUploadDir() {
		return moduleUploadDir;
	}
	public void setModuleUploadDir(String moduleUploadDir) {
		this.moduleUploadDir = moduleUploadDir;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

}