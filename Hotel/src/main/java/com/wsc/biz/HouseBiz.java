package com.wsc.biz;
import com.wsc.model.*;
import com.wsc.mapper.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
@Service
public class HouseBiz implements IHouseBiz{
	@Resource
	private HouseMapper mapper;

	@Override
	public boolean save(House bean) {
		if(bean.getHid()!=null){
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
	public House find(Integer id) {
		return this.mapper.selectOne(id);
	}

	@Override
	public List<House> query(Map<String,String> map) {
		return this.mapper.select(map);
	}
	
	
}
