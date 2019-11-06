package com.example.demo.dao;

import com.example.demo.Employee;
import javax.persistence.*;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private EntityManager entityManager; 
	
	
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.save(employee);
		return employee;
	}

}
