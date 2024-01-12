package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;
@Entity
@Table(name="employee")
public class Employee {
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", type=" + type + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empId;
	@Column(name="First_Name",length = 30)
	private String firstName;
	@Column(name="Last_Name",length = 30)
	private String lastName;
	@Column(unique = true)
	private String email;
	
	private String password;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	@Lob
	private byte[] image;
	public Employee(String firstName, String lastName, String email, String password, LocalDate dob,
			EmployeeType type, byte[] image) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.type = type;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Integer getEmpId() {
		return empId;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public Employee(String firstName, String lastName, String email, String password, LocalDate dob,
			EmployeeType type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.type = type;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Employee(String lastName) {
		this.lastName = lastName;
	}
	
	
}
