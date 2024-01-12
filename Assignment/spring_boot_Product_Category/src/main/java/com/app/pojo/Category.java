package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="category")
public class Category extends BaseEntity{
	@Column(nullable = false,unique = true,length = 20)
	private String name;
	private String description;
	
}
