package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class FindCandidateBean {
	private int candid;
	private Candidate candidate;
	public FindCandidateBean() {
		// TODO Auto-generated constructor stub
	}
	public int getCandid() {
		return candid;
	}
	public void setCandid(int candid) {
		this.candid = candid;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public void findCandidate() {
		try(CandidateDaoImpl cdao = new CandidateDaoImpl()){
			candidate=cdao.findById(candid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
