package com.wsc.Controls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.util.concurrent.RateLimiter;
import com.wsc.biz.HouseBiz;
import com.wsc.model.House;

@RestController
public class houseControl {
	   final RateLimiter limit=RateLimiter.create(2);
		@Resource
		private HouseBiz hBiz;
		//@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
		
		@RequestMapping(value="/addHouse",method=RequestMethod.POST)
		public  boolean addHouse(HttpServletRequest request)
		{
			
			if(!limit.tryAcquire()) {
				
			}
			boolean flag=false;
			String hid=request.getParameter("hid");
			String hname=request.getParameter("hname");
			String kid=request.getParameter("kid");
			String beds=request.getParameter("beds");
			String size=request.getParameter("size");
			String price=request.getParameter("price");
			String info=request.getParameter("info");
			int style=Integer.parseInt(request.getParameter("style"));
			String status=request.getParameter("status");
			House bean=new House();
			if(beds!=null&&!beds.equals("")) {
				bean.setBeds(Integer.parseInt(beds));
			}
			if(hname!=null&&!beds.equals("")) {
			bean.setHname(hname);
			}
			if(info!=null&&!beds.equals(""))
			{
				bean.setInfo(info);
			}
			if(kid!=null&&!beds.equals(""))
			{
				bean.setKid(Integer.parseInt(kid));
			}
			if(size!=null&&!beds.equals("")) {
				bean.setSize(Integer.parseInt(size));
			}
			if(price!=null&&!beds.equals("")) {
			bean.setPrice(Float.parseFloat(price));
			}
			if(style==0)   //添加
			{
				flag=hBiz.save(bean);
				
			}else {  //修改
				if(Integer.parseInt(hid)<0)
				{
					return false;
				}
				if(status!=null) {
					bean.setStatus(Integer.parseInt(status));
				}
				
				bean.setHid(Integer.parseInt(hid));
				flag=hBiz.save(bean);
				
			}
//			
			
			return flag;
		}
		
		@RequestMapping(value="/houseQuery",method=RequestMethod.POST)
		public  Map<String,Object> allHouse(String hname,String kid,String beds,String page,String rows,String status)
		{
			Map<String,String> map=new HashMap<String,String>();
			if(hname!=null&&!hname.equals(""))
			{
				map.put("hname", hname);
				
			}
			if(kid!=null&&!kid.equals(""))
			{
				 map.put("kid", kid);
			}
			if(beds!=null&&!beds.equals(""))
			{
				 map.put("beds", beds);
			}
			if(status!=null&&!status.equals(""))
			{
				map.put("status", status);
			}
			
			int p=1,r=10;
			
			if(page!=null&&!page.equals(""))
			{
				p=Integer.parseInt(page);
			}
			if(rows!=null&&!rows.equals(""))
			{
				r=Integer.parseInt(rows);
			}
			PageHelper.startPage(p,r);
			
			List<House> list=hBiz.query(map);
			Page pg=(Page)list;
			int pages=pg.getPages();
			Map<String,Object> map2=new HashMap<String,Object>();
			map2.put("list", list);
			map2.put("pages", pages);
			
			return map2;
			
		}
		
		
		@RequestMapping(value="/choose",method=RequestMethod.POST)
		public House choose(int hid)
		{
			
			return this.hBiz.find(hid);
			
			
		}
		
		
		@RequestMapping(value="/reservaQuery",method=RequestMethod.POST)
		public List<House> reservaQuery()
		{
			return  this.hBiz.query(null);
		}
		
		
}
