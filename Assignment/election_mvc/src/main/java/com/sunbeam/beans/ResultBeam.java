package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBeam {
	private List<Candidate> clist;
	public ResultBeam() {
		// TODO Auto-generated constructor stub
	}
	public List<Candidate> getClist() {
		return clist;
	}
	public void setClist(List<Candidate> clist) {
		this.clist = clist;
	}
	public void allCandidate() {
		try(CandidateDaoImpl cdao=new CandidateDaoImpl()){
			clist=cdao.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
