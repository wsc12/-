package com.wsc.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.*;
@Mapper
public interface ImgMapper{
	public boolean insert(Img bean);
	public Img selectOne(Integer id);
	public boolean delete(Integer id);
	public List<Img> select();
	public boolean update(Img bean);
	public List<String> selectHouse(String belong);
}