package com.wsc.biz;
import com.wsc.model.*;
import com.wsc.mapper.*;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class RuleBiz implements IRuleBiz{
	
	@Resource
	private RuleMapper mapper ;

	@Override
	public boolean save(Rule bean) {
		
			return this.mapper.insert(bean);
		
	}

	@Override
	public boolean remove(Integer aid) {
		return this.mapper.delete(aid);
	}

	@Override
	public Rule find(Integer aid) {
		return this.mapper.selectOne(aid);
	}

	@Override
	public List<Rule> query() {
		return this.mapper.select();
	}
}
