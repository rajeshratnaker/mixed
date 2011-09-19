package com.rajesh.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JdbcUtil {
	public static DataSource getBasicDataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		basicDataSource.setUrl("jdbc:hsqldb:file:src/database/hsqlDb");
		basicDataSource.setUsername("sa");
		basicDataSource.setPassword("");
		
		return basicDataSource;
	}
}
