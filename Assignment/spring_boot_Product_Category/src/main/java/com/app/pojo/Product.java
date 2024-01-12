package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="product")
public class Product extends BaseEntity {
	@Column(unique = true,length = 30)
	private String name;
	@Column(length = 100)
	private String description;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	private double price;
	private int stock;
	private LocalDate expDate;
	public Product(String name, String description, Category category, double price, int stock, LocalDate expDate) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.stock = stock;
		this.expDate = expDate;
	}
	
}
