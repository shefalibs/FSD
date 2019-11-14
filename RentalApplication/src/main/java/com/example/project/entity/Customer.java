package com.example.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "customer")
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customer_id;
	
	@Column(name="customer_firstname")
	private String customer_firstname;
	
	@Column(name="customer_lastname")
	private String customer_lastname;
	
	@Column(name="customer_phone")
	private int customer_phone;
	
	@Column(name="customer_email")
	private String customer_email;
	
	@Column(name="customer_password")
	private String customer_password;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Address> addresses;

	

}
