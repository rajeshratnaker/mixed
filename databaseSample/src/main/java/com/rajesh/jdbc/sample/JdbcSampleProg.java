package com.rajesh.jdbc.sample;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rajesh.model.Employee;
import com.rajesh.util.JdbcUtil;


public class JdbcSampleProg {
	
	public static void main(String[] args) {
		callMe();
	}
	
	public static void callMe(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtil.getBasicDataSource());
		System.out.println(jdbcTemplate.queryForInt("select count(0) from employee"));
		
		Employee emp = jdbcTemplate.queryForObject("select empid, name from employee where empid=1", new RowMapper<Employee>(){
			
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new Employee(rs.getInt("empid"), rs.getString("name"));
			}
						
		});
		
		System.out.println("Query for object : " + emp);
		
		List<Employee> query = jdbcTemplate.query("select empid, name from employee ", new RowMapper<Employee>(){
			
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				return new Employee(rs.getInt("empid"), rs.getString("name"));
			}
						
		});
		
		System.out.println("Printing objects: " + Arrays.toString(query.toArray()));
	}
	
	
}
