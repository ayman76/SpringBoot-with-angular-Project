package com.global.springAnguler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.global.springAnguler.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
