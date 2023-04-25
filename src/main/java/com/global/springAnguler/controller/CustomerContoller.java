package com.global.springAnguler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.springAnguler.entity.Customer;
import com.global.springAnguler.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerContoller {

	private final CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(customerService.findById(id));
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(customerService.findAll());
	}

	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.insert(customer));
	}

	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.update(customer));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		customerService.deleteById(id);
	}

}
