package com.wsc.Controls;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wsc.biz.HouseBiz;
import com.wsc.biz.PriceBiz;
import com.wsc.biz.ReservaBiz;
import com.wsc.model.House;
import com.wsc.model.Price;
import com.wsc.model.Reserva;

@RestController
public class reservaControl {
	@Resource
	private ReservaBiz rbiz;
	@Resource
	private PriceBiz pbiz;
	@Resource
	private HouseBiz hBiz;
	
			
	@RequestMapping(value="/reservetion",method=RequestMethod.POST)
	public boolean reservetion(Reserva rs)
	{
		House rs2=new House();
		rs2.setHid(rs.getHid());
		rs2.setStatus(2);
		return rbiz.save(rs)&&hBiz.save(rs2); 
	}
	
	@RequestMapping(value="/setPrice",method=RequestMethod.POST)
	public boolean setPrice(Price pc)
	{
		if(pc.getKid()==null)
		{
			return false;
		}
		
		return pbiz.save(pc);
		
		
	}
	@RequestMapping(value="/removePrice/{id}",method=RequestMethod.POST)
	public boolean removePrice(@PathVariable("id") int id)
	{
		return pbiz.remove(id);
	}
	
	
	
	@RequestMapping("/discountPrice")
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public List<Price> getPrice()
	{
		 return pbiz.Query();
	}
	
	@RequestMapping("/getOne")
	public Float getOne(int hid,int kid,@RequestParam("reservaDate") String rdate)
	{
		
		Price pc=pbiz.QueryOne(kid,rdate);
		if(pc!=null) {
			
					Float price=pc.getLastPrice();
					
					return price;
		}else {
			 Float price=hBiz.find(hid).getPrice();
			
			 return price;
		}
	}
	
	@RequestMapping(value="/reservaQuery",method=RequestMethod.GET)
	public List<Reserva> Query(){
		return rbiz.Query();
	}
	
	// the custom is unregister  退订
	@RequestMapping(value="/removeQuery",method=RequestMethod.GET)
	public boolean remove(int id){
		return rbiz.remove(id);
	}
	//入住
	@RequestMapping("/into")
	public boolean into(int id) {
		return rbiz.into(id);
	}
	
	
	
	
		
}
