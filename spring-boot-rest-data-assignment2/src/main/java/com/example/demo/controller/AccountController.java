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

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping("/accounts")
	public Page<Account> getAllAccounts(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@PostMapping("/accounts")
	public Account createAccount(@Valid @RequestBody Account account) {
		return accountRepository.save(account);
	}

	@PutMapping("/accounts/{accountId}")
	public Account updateAccount(@PathVariable Long accountId, @Valid @RequestBody Account accountRequest) {
		return accountRepository.findById(accountId).map(account -> {
			account.setAccountName(accountRequest.getAccountName());
			account.setAccountType(accountRequest.getAccountType());
			account.setEmail(accountRequest.getEmail());
			return accountRepository.save(account);
		}).orElseThrow(() -> new ResourceNotFoundException("AccountId " + accountId + " not found"));
	}

	@DeleteMapping("/accounts/{accountId}")
	public ResponseEntity<?> deleteAccount(@PathVariable Long accountId) {
		return accountRepository.findById(accountId).map(account -> {
			accountRepository.delete(account);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("AcocuntId " + accountId + " not found"));
	}

}