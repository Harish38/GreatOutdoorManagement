package com.cg.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Customer;

@Repository
public interface CustomerDao  extends JpaRepository<Customer,Integer> {
	
}
