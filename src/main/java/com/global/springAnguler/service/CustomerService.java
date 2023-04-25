package com.global.springAnguler.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.global.springAnguler.entity.Customer;
import com.global.springAnguler.repository.CustomerRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepo customerRepo;

	public Customer findById(Long id) {
		return customerRepo.findById(id).orElseThrow();
	}

	public Customer getById(Long id) {
		return customerRepo.getReferenceById(id);
	}

	public List<Customer> findAll() {
		return customerRepo.findAll();
	}

	public Long count() {
		return customerRepo.count();
	}

	public Customer insert(Customer customer) {
		return customerRepo.save(customer);
	}

	public Customer update(Customer customer) {
		Customer updated = getById(customer.getId());
		updated.setName(customer.getName());
		updated.setAddress(customer.getAddress());
		updated.setMobile(customer.getMobile());

		return customerRepo.save(updated);
	}

	public void deleteById(Long id) {
		customerRepo.deleteById(id);
	}

}
