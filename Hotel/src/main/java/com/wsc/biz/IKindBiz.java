package com.wsc.biz;
import com.wsc.model.*;
import java.util.List;
public interface IKindBiz{
	public boolean save(Kind kind);
	public boolean remove(Integer id);
	public Kind find(Integer id);
	public List<Kind> query();
}