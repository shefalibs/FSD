package com.example.demo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document (collection="A")
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Todo {
	private ObjectId _id;
	private String name;
	private boolean isCompleted;
	public String get_id() {
		return _id.toHexString();
	}
}
