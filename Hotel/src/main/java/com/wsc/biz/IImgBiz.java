package com.wsc.biz;
import com.wsc.model.*;
import java.util.List;
public interface IImgBiz{
	public boolean save(Img img);
	public boolean remove(Integer id);
	public Img find(Integer id);
	public List<Img> query();
}