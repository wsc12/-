package com.wsc.Controls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wsc.biz.KindBiz;
import com.wsc.model.Kind;

@RestController
public class kindControl {
		@Resource
		KindBiz dao;
	
		@RequestMapping("/KindQuery")
		public List<Kind> KindQuery()
		{
			return dao.query();
		}
		
		@RequestMapping(value="/kindSave",method=RequestMethod.POST)
		public boolean save(String id,String name,String icon,String info,String status)
		{
			boolean flag=false;
			Kind k=new Kind();
			if(name!=null&&!name.equals(""))
			{
				k.setName(name);
			}
			if(icon!=null&&!icon.equals(""))
			{
				k.setIcon(icon);
			}
			if(info!=null&&!info.equals(""))
			{
				k.setInfo(info);
				
			}
			if(status!=null&&!status.equals(""))
			{
				k.setStatus(Integer.parseInt(status));
			}
			if(id!=null&&!id.equals(""))
			{
				k.setId(Integer.parseInt(id));
			
			}
			flag=dao.save(k);
			return flag;
		}
}
