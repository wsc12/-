package com.wsc.biz;
import com.wsc.model.*;
import com.wsc.mapper.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class ImgBiz implements IImgBiz{
	@Resource
	private ImgMapper mapper;

	@Override
	public boolean save(Img bean) {
		if(bean.getId()!=null){
			return this.mapper.update(bean);
		}else{
			return this.mapper.insert(bean);
		}
	}

	@Override
	public boolean remove(Integer id) {
		return this.mapper.delete(id);
	}

	@Override
	public Img find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Img> query() {
		return this.mapper.select();
	}
	
	
	public List<String> selectHouse(String belong)
	{
		return this.mapper.selectHouse(belong);
	}
}
