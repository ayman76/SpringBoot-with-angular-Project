package com.global.springAnguler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.springAnguler.entity.Customer;

import lombok.RequiredArgsConstructor;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
