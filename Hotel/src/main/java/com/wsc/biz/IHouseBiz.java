package com.wsc.biz;
import com.wsc.model.*;
import java.util.List;
import java.util.Map;
public interface IHouseBiz{
	public boolean save(House house);
	public boolean remove(Integer id);
	public House find(Integer id);
	public List<House> query(Map<String,String> map);
}