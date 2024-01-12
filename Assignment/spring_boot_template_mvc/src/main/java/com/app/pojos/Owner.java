package com.app.pojos;

import javax.persistence.CascadeType;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="owner")
public class Owner extends BaseEntity {
	private String name;
	private int worth;
	@OneToOne(mappedBy = "owner",cascade = CascadeType.ALL,orphanRemoval = true)
	private Team team;
	@Embedded
	private Adhaar adhaar;
	
	public Adhaar getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(Adhaar adhaar) {
		this.adhaar = adhaar;
	}
	public Owner() {
		// TODO Auto-generated constructor stub
	}
	public void addTeam(Team t) {
		this.team=t;
		team.setOwner(this);
	}
	public void removeTeam() {
		this.team=null;
	}
	public Owner(String name, int worth) {
		this.name = name;
		this.worth = worth;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWorth() {
		return worth;
	}
	public void setWorth(int worth) {
		this.worth = worth;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
