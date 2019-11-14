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
@Table(name = "renter")
@Data
public class Renter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="renter_id")
	private int renter_id;
	
	@Column(name="renter_firstname")
	private String renter_firstname;
	
	@Column(name="renter_lastname")
	private String renter_lastname;
	
	@Column(name="renter_phone")
	private int renter_phone;
	
	@Column(name="renter_email")
	private String renter_email;
	
	@Column(name="renter_password")
	private String renter_password;
	
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "renter", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH })
	private List<Address> addresses;
	

}
