package com.example.demo;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer>{
	@Query("SELECT name FROM Product where name like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
	
	public List<Product> findBynameContainsAllIgnoreCase(String name);

	public List<Product> findAllByOrderByNameAsc();

}
