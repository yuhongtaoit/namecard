package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhongwei.namecard.entity.ResourceEntity;

@Mapper
public interface ResourceDao {
	
	List<ResourceEntity> getAll();
	
	ResourceEntity getOne(Long id);
	
	List<ResourceEntity> getResourcesByIds(List<Integer> resourceIds);

	void insert(ResourceEntity resource);

	void update(ResourceEntity resource);
	
	void delete(Long id);

	ResourceEntity getResourceByUrl(String url);

}