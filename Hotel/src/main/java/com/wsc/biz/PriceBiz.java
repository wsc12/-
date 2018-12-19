package com.wsc.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsc.mapper.PriceMapper;
import com.wsc.model.Price;

@Service
public class PriceBiz {
				@Resource
				private PriceMapper dao;
				
				public  boolean save(Price pc)
				{
					
					if(pc.getId()!=null)
					{
						System.out.println(pc.getId());
						return dao.update(pc);
						
					}else {
						return dao.insert(pc);
					}
				}
				
				public boolean remove(int id)
				{
					return dao.delete(id);
				}
				
				
				public List<Price> Query(){
					
					return dao.select();
				}
				
				public Price QueryOne(Integer id,String rdate){
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("id", id);
					map.put("rdate", rdate);
					return dao.selectOne(map);
				}
				
}
