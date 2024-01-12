package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

//id , name, abbreviation,owner,max_age,batting_avg,wickets_taken
//one , parent, inverse
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {
	@Column(length = 100)
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@OneToOne
	@JoinColumn(name="owner_id",nullable=false)
	private Owner owner;
	@Column(name = "max_age")
	private int maxAge;// max age of the player allowed in this team
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	@OneToMany(mappedBy = "myTeam",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Player> list=new ArrayList<>();
	public Team() {
		// TODO Auto-generated constructor stub
	}
	public void addPlayer(Player p) {
		list.add(p);
		p.setMyTeam(this);
	}
	public void removePlayer(Player p) {
		list.remove(p);
		p.setMyTeam(null);
	}
	public Team(String name, String abbreviation, int maxAge, double battingAvg,
			int wicketsTaken) {
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	public Team(Integer id,String abbreviation) {
		setId(id);
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Integer getTeamId() {
		
		return getId();
	}


	public List<Player> getList() {
		return list;
	}

	public void setList(List<Player> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}

}
