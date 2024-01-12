package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class UpdateCandidateBean {
	private int id;
	private String candname;
	private String party;
	private int Votes;
	public UpdateCandidateBean() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCandname() {
		return candname;
	}
	public void setCandname(String candname) {
		this.candname = candname;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return Votes;
	}
	public void setVotes(int votes) {
		Votes = votes;
	}
	public void updateCandidate() {
		
		try(CandidateDaoImpl cdao=new CandidateDaoImpl()){
			Candidate cand=new Candidate();
			cand.setId(id);
			cand.setName(candname);
			cand.setParty(party);
			cand.setVotes(Votes);
			cdao.update(cand);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
