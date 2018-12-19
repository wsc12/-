package com.wsc.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.*;
@Mapper
public interface HouseMapper{
	public boolean insert(House bean);
	public House selectOne(Integer id);
	public boolean delete(Integer id);
	public List<House> select(Map<String,String> map);
	public boolean update(House bean);
}