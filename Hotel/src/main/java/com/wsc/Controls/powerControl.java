package com.wsc.Controls;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsc.biz.AdminBiz;
import com.wsc.biz.PowerBiz;
import com.wsc.biz.RuleBiz;
import com.wsc.model.Power;
import com.wsc.model.Rule;
import com.wsc.model.admin;

@RestController
public class powerControl {
	
	@Resource
	private PowerBiz pbiz;
	@Resource
	private AdminBiz abiz;
	@Resource
	private RuleBiz rbiz;

	@RequestMapping("/allPower")
	public List<Power> allPower()
	{
		return pbiz.query();
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public boolean addAdmin(String ps,@RequestParam("name") String name,@RequestParam("password") String password,@RequestParam("status") String status) {
		boolean flag=false;
		String powers[]=ps.split(",");
		admin admin=new admin();
		MD5 md=new MD5();
		admin.setName(name);
		admin.setPassword(md.md5crypt(password));
		admin.setStatus(status);
		flag=abiz.save(admin);
		int t=abiz.queryOne(name);
		if(ps!=null&&!ps.equals(""))
		{
			for(String s:powers)
			{
				int n=Integer.parseInt(s);
				Rule rl=new Rule();
				rl.setAid(t);
				rl.setPid(n);
				flag=rbiz.save(rl);
				
			}
		}else {
			try {
				throw new SQLException("保存失败");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
}
