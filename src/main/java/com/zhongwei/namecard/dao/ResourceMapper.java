package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.Resource;

@Mapper
public interface ResourceMapper {
	
	List<Resource> getAll();
	
	Resource getOne(Integer id);
	
	List<Resource> getResourcesByIds(List<Integer> resourceIds);

	void insert(Resource resource);

	void update(Resource resource);
	
	void delete(Long id);

	Resource getResourceByUrl(String url);

}