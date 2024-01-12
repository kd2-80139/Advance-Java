package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class VoteBean {
	private int candidate;
	private String message;
	private int userid;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public VoteBean() {
		// TODO Auto-generated constructor stub
	}
	public int getCandidate() {
		return candidate;
	}
	public void setCandidate(int candidate) {
		this.candidate = candidate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void addVote() {
		try(UserDaoImpl udao=new UserDaoImpl()){
			User u=udao.findById(userid);
			if(u.getStatus()==1) {
				setMessage("Already Voted");
				return;
			}
		try(CandidateDaoImpl cdao=new CandidateDaoImpl()){
			cdao.incrementVote(candidate);
			udao.updateStatus(userid, true);
			setMessage("Vote Done");
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
