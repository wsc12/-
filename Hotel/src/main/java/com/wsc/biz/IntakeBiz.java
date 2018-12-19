package com.wsc.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsc.mapper.IntakeMapper;
import com.wsc.model.Intake;

@Service
public class IntakeBiz {
		@Resource
		private IntakeMapper map;
		
		public boolean save(int id) {
			return map.insert(id);
		}
		
		public boolean saveValue(Intake it) {
			return map.insertValue(it);
		}
		
		public List<Intake> Query(){
			return map.select();
		}
		public boolean change(int id) {
			return map.update(id);
		}
}
