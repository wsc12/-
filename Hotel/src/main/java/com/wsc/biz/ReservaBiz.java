package com.wsc.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsc.mapper.ReservaMapper;
import com.wsc.model.Reserva;

@Service
public class ReservaBiz {
		@Resource
		 private ReservaMapper dao;
		 
		 public boolean save(Reserva rs)
		 {
			 if(rs.getId()!=null) {
				 return dao.update(rs);
				 
			 }else {
				 return dao.insert(rs);
			 }
			 
		 }
		 
		 public List<Reserva> Query()
		 {
			 return dao.select();
		 }
		 
		 public boolean remove(int id)
		 {
			 return dao.delete(id);
		 }
		 
		 public boolean into(int id) {
			return dao.insertInto(id);
		 }
		 
		 
}
