package com.wsc.biz;
import com.wsc.model.*;
import java.util.List;
public interface IPowerBiz{
	public boolean save(Power power);
	public boolean remove(Integer id);
	public Power find(Integer id);
	public List<Power> query();
}