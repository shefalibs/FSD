package com.example.demo;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/list")
	public String listProducts(Model theModel) {
		
		// get employees from db
		List<Product> theProducts = productService.findAll();
		
		// add to the spring model
		theModel.addAttribute("products", theProducts);
		return "index";
	}
	
	
	
	@RequestMapping("/search")
	@ResponseBody
	public List<String> search(HttpServletRequest request) {
		return productService.search(request.getParameter("term"));
	}
	
	@GetMapping("/product1/search")
	public String delete(@RequestParam("name") String name,
						 Model theModel) {
		
		// delete the employee
		List<Product> theEmployees = productService.searchBy(name);
		
		// add to the spring model
		theModel.addAttribute("products", theEmployees);
		
		// send to /employees/list
		return "product/list";
		
	}
}