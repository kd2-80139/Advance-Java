package com.sunbeam.dao;
import java.sql.PreparedStatement;

import com.sunbeam.interfaces.SharesDaoInf;

public class SharesDao extends Dao implements SharesDaoInf {
	

	//adding shared reviews to the desired users
	public void add(int rid,int uid) throws Exception {
		String sql = "insert into shares values(?,?)";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
			stmt.setInt(2, uid);
			stmt.executeUpdate();
		}
	}
	
	//deleting shared reviews
	public void delete(int rid) throws Exception{
		String sql = "delete from shares where review_id = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setInt(1, rid);
		
			stmt.executeUpdate();
		}
	}
}
