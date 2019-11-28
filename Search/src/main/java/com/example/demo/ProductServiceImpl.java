package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	
	private ProductRepository productRepository;
	
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	
	public List<String> search(String keyword) {
		return productRepository.search(keyword);
	}

	
	public List<Product> searchBy(String name) {
		List<Product> results = null;
		
		if (name != null ) {
			results = productRepository.findBynameContainsAllIgnoreCase(name);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

	
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return  productRepository.findAllByOrderByNameAsc();
	}
}