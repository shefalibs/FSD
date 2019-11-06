package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Employee;



@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("employee") Employee employee)
	{
		return "process-form";
	}
}
