package com.wsc.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.*;
@Mapper
public interface RuleMapper{
	public boolean insert(Rule bean);
	public Rule selectOne(Integer aid);
	public boolean delete(Integer aid);
	public List<Rule> select();
	public boolean update(Rule bean);
}