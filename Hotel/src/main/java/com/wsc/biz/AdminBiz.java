package com.wsc.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsc.mapper.AdminMapper;
import com.wsc.model.admin;

@Service
public class AdminBiz {
	@Resource
	private AdminMapper dao;
	
		public boolean save(admin admin)
		{
			if(admin.getId()==null)
			{
				return dao.insert(admin);
			}else {
				return dao.update(admin);
			}
		}
		
		
		public int queryOne(String name){
				return dao.selectOne(name);
		}
}
