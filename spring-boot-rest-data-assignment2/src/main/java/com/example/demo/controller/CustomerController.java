package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/accounts/{accountId}/customers")
	public Page<Customer> getAllCommentsByCustomerId(@PathVariable(value = "accountId") Long customerId, Pageable pageable) {
		return customerRepository.findByAccountId(customerId, pageable);
	}

	@PostMapping("/accounts/{accountId}/customers")
	public Customer createCustomer(@PathVariable(value = "acocuntId") Long accountId, @Valid @RequestBody Customer customer) {
		return accountRepository.findById(accountId).map(account -> {
			customer.setAccount(account);
			return customerRepository.save(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + accountId + " not found"));
	}

	@PutMapping("/accounts/{accountId}/customers/{customerId}")
	public Customer updateCustomer(@PathVariable(value = "accountId") Long accountId,
			@PathVariable(value = "customerId") Long customerId, @Valid @RequestBody Customer customerRequest) {
		if (!accountRepository.existsById(accountId)) {
			throw new ResourceNotFoundException("AccountId " + accountId + " not found");
		}

		return customerRepository.findById(customerId).map(customer -> {
			customer.setFirstName(customerRequest.getFirstName());
			customer.setLastName(customerRequest.getLastName());
			return customerRepository.save(customer);
		}).orElseThrow(() -> new ResourceNotFoundException("CustomerId " + customerId + "not found"));
	}

	@DeleteMapping("/accounts/{accountId}/customers/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "accountId") Long accountId,
			@PathVariable(value = "customerId") Long customerId) {
		return customerRepository.findByIdAndAccountId(customerId, accountId).map(customer -> {
			customerRepository.delete(customer);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(
				"Customer not found with id " + customerId + " and accountId " + accountId));
	}
}
