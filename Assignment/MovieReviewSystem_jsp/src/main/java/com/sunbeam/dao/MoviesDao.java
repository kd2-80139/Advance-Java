package com.sunbeam.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sunbeam.interfaces.MoviesDaoInf;
import com.sunbeam.pojo.Movies;
/**
 * @author Ritu And Ujjwal
 * prn no ritu = 230940820086
 * prn no ujjwal = 230940820111
 *
 */
public class MoviesDao extends Dao implements MoviesDaoInf{

	
	//displaying all movies
	public List<Movies> display() throws Exception{
		String sql="select * from movies";
		List<Movies> list=new ArrayList<Movies>();
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			try(ResultSet rs=stmt.executeQuery()){
				while(rs.next()) {
					Movies q=new Movies();
					q.setId(rs.getInt("id"));
					q.setTitle(rs.getString("title"));
					q.setRelease_date(rs.getDate("release_date"));
					list.add(q);
				}
			}
		}
		return list;
	}
	
}

