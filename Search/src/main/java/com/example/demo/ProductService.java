package com.example.demo;

import java.util.List;

public interface ProductService {
	public List<Product> findAll();
	public List<String> search(String keyword);
	public List<Product> searchBy(String name);
}
