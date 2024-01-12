/**
 * 
 */
package com.sunbeam.interfaces;

import java.util.List;

import com.sunbeam.pojo.Movies;

/**
 * @author HP
 *
 */
public interface MoviesDaoInf {
	public List<Movies> display() throws Exception;
	public Movies findById(int id)throws Exception;
}
