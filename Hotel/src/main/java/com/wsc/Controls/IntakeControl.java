package com.wsc.Controls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsc.biz.HouseBiz;
import com.wsc.biz.IntakeBiz;
import com.wsc.model.House;
import com.wsc.model.Intake;

@RestController
public class IntakeControl {
	@Resource
	private IntakeBiz IBiz;
	@Resource
	private reservaControl RCtrol;
	@Resource
	private HouseBiz hBiz;
	
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@RequestMapping("/intake")
	public boolean intake(@RequestParam("id") int id) {
		   boolean flag=false;
			House rs2=new House();
			rs2.setHid(id);
			rs2.setStatus(3);
			if(IBiz.save(id)&&RCtrol.into(id)&&hBiz.save(rs2)) {
				  flag=true;
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				
			}
		
			return flag;
		
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@RequestMapping("/Tointake")
	public boolean toIntake(Intake it) {
			boolean flag=false;
			House rs2=new House();
			rs2.setHid(it.getHid());
			rs2.setStatus(3);
			if(IBiz.saveValue(it)&&hBiz.save(rs2)) {
					flag = true;
			}else {
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				
			}
			return flag;
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@RequestMapping("/intakeQuery")
	public List<Intake> intakeList(){
		
		return IBiz.Query();
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	@RequestMapping("/intakeUpdate/{id}")
	public boolean intakeUpdate(@PathVariable("id") int id){
		
		return IBiz.change(id);
	}
	

}
