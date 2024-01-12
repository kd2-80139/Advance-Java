package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBeam {
	private int candid;
	public DeleteCandidateBeam() {
		// TODO Auto-generated constructor stub
	}
	public int getCandid() {
		return candid;
	}
	public void setCandid(int candid) {
		this.candid = candid;
	}
	public void deleteCandidate() {
		try(CandidateDaoImpl cdao=new CandidateDaoImpl()){
			cdao.deleteById(candid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
