package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class Adhaar {
	private String cardNo;
	private LocalDate issueDate;
	private String location;
	public Adhaar() {
		// TODO Auto-generated constructor stub
	}
	
	public Adhaar(String cardNo, LocalDate issueDate, String location) {
		super();
		this.cardNo = cardNo;
		this.issueDate = issueDate;
		this.location = location;
	}

	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
