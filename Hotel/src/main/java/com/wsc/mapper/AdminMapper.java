package com.wsc.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.admin;

@Mapper
public interface AdminMapper {
	
	public boolean insert(admin admin);
	public boolean update(admin admin);
	public int selectOne(String name);

}
