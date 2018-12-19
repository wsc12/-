package com.wsc.biz;
import com.wsc.model.*;
import java.util.List;
public interface IRuleBiz{
	public boolean save(Rule rule);
	public boolean remove(Integer aid);
	public Rule find(Integer aid);
	public List<Rule> query();
}