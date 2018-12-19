package com.wsc.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.*;
@Mapper
public interface PowerMapper{
	public boolean insert(Power bean);
	public Power selectOne(Integer id);
	public boolean delete(Integer id);
	public List<Power> select();
	public boolean update(Power bean);
}