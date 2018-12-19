package com.wsc.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.Price;

@Mapper
public interface PriceMapper {
		public List<Price> select();
		public boolean insert(Price pc);
		public Price selectOne(Map<String, Object> map);
		public boolean update(Price pc);
		public boolean delete(int id);
		
		
		
		
}
