package com.wsc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wsc.model.Reserva;
@Mapper
public interface ReservaMapper {
		public boolean insert(Reserva rs);
		public List<Reserva> select();
		public boolean update(Reserva rs);
		public boolean delete(int id);
		public boolean insertInto(int id);
}
