package com.wsc.Controls;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wsc.biz.HouseBiz;
import com.wsc.biz.ImgBiz;
import com.wsc.model.House;
import com.wsc.model.Img;

@Controller
public class imgControl {
	@Resource
	private HouseBiz dao;
	
		@RequestMapping("/upload")
		@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
		public @ResponseBody   boolean  SaveImg(MultipartFile pica,MultipartFile picb,MultipartFile picc,MultipartFile picd,HttpServletRequest request,int hid) {
			boolean flag=false;
			String part=request.getSession().getServletContext().getRealPath("/images");
			String sign=part.substring(part.lastIndexOf("\\")+1);			
			int n=0;
			House hs=new House();
			hs.setHid(hid);
			if(pica!=null)
			{
				
				String name=pica.getOriginalFilename();
				String etc=name.substring(name.lastIndexOf("."));
				name=System.currentTimeMillis()+(n++)+etc;
				String newPart=part+"\\"+name;
				File dest=new File(newPart);
				try {
					pica.transferTo(dest);
				}catch(Exception e)
				{
					
					e.printStackTrace();
					return flag;
				}
				hs.setPica(sign+"/"+name);		
			}	
			if(picb!=null)
			{
				
				String name=picb.getOriginalFilename();
				String etc=name.substring(name.lastIndexOf("."));
				name=System.currentTimeMillis()+(n++)+etc;
				String newPart=part+"\\"+name;
				File dest=new File(newPart);
				try {
					picb.transferTo(dest);
				}catch(Exception e)
				{
					e.printStackTrace();
					return flag;
				}
				hs.setPicb(sign+"/"+name);		
			}	
			if(picc!=null)
			{
				
				String name=picc.getOriginalFilename();
				String etc=name.substring(name.lastIndexOf("."));
				name=System.currentTimeMillis()+(n++)+etc;
				String newPart=part+"\\"+name;
				File dest=new File(newPart);
				try {
					picc.transferTo(dest);
				}catch(Exception e)
				{
					e.printStackTrace();
					return flag;
				}
				hs.setPicc(sign+"/"+name);		
			}
			if(picd!=null)
			{
				
				String name=picd.getOriginalFilename();
				String etc=name.substring(name.lastIndexOf("."));
				name=System.currentTimeMillis()+(n++)+etc;
				String newPart=part+"\\"+name;
				File dest=new File(newPart);
				try {
					picd.transferTo(dest);
				}catch(Exception e)
				{
					e.printStackTrace();
					return flag;
				}
				hs.setPicd(sign+"/"+name);		
				
			}			
			if(dao.save(hs)) {
				flag=true;
			}
					
						
						
			return flag;	
			
		}
		
		
		@RequestMapping("/onloadImg")
		public @ResponseBody House selectImgs(int hid){
			
				return this.dao.find(hid);
		}
}
