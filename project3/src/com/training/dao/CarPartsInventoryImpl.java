package com.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.training.entity.CarParts;

@Component("carPartsInv")
public class CarPartsInventoryImpl implements CarPartsInventory {

	// IN this example instead of writting traditional jdbc code,
	// we are going to use an API class provided by Spring called
	// as JDBCTemplate Class
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addNewPart(CarParts carParts) {
		jdbcTemplate.update("insert into tbl_carparts values(?,?,?)",carParts.getPartNo(),carParts.getPartName(),carParts.getQuantity());;
	}

	@Override
	public CarParts loadCarParts(int partNo) {
		CarParts part = jdbcTemplate.queryForObject("select * from tbl_carparts where partno = ?",new CarPartsMapper(),partNo);	
		return part;
	}

	@Override
	public List<CarParts> loadAllAvailableCarParts() {

	List<CarParts> parts = jdbcTemplate.query("select * from tbl_carparts ",new CarPartsMapper());	
	return parts;
}


class CarPartsMapper implements RowMapper<CarParts>{
	@Override
	public CarParts mapRow(ResultSet rs, int index) throws SQLException{
		com.training.entity.CarParts part = new CarParts();
		part.setPartNo(rs.getInt("PartNo"));
		part.setPartName(rs.getString("PartName"));
		part.setQuantity(rs.getInt("Quantity"));
		return part;				
	}
}
}