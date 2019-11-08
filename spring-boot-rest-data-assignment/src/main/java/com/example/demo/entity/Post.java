package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Post {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;
	@Column(name="post_name")
	private String postName;
	@Column(name="post_date")
	private Date postDate;
	
}
