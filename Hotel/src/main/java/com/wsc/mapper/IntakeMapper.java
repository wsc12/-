package com.wsc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.Intake;

@Mapper
public interface IntakeMapper {
		public boolean insert(int id);
		public boolean insertValue(Intake it);
		List<Intake> select();
		boolean update(int id);
}
