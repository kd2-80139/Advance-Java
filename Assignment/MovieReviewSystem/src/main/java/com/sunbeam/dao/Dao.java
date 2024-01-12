package com.sunbeam.dao;

import java.sql.Connection;

import com.sunbeam.utils.DbUtil;

public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() {
		// TODO Auto-generated constructor stub
		try {
			con=DbUtil.getCon();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		if(con!=null) {
			con.close();
		}	
	}
	
}
