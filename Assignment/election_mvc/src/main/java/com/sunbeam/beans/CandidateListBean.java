package com.sunbeam.beans;

import java.util.List;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateListBean {
	private List<Candidate> clist;
	public CandidateListBean() {
		// TODO Auto-generated constructor stub
	}
	public List<Candidate> getClist() {
		return clist;
	}
	public void setClist(List<Candidate> clist) {
		this.clist = clist;
	}
	public void candidateList() {
		try(CandidateDaoImpl cdao=new CandidateDaoImpl()){
			clist=cdao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
