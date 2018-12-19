package com.wsc.biz;
import com.wsc.model.*;
import com.wsc.mapper.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class PowerBiz implements IPowerBiz{
	@Resource
	private PowerMapper mapper;

	@Override
	public boolean save(Power bean) {
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
	public Power find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<Power> query() {
		return this.mapper.select();
	}
}
