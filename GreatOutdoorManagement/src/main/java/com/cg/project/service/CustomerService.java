package com.cg.project.service;

import java.util.List;

import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.entity.Login;
import com.cg.project.exception.CustomerException;

public interface CustomerService {

	public Customer createCustomer(Customer customer);

	public Customer updateCustomer(int customerId, Customer cust) throws CustomerException;

	public Customer RetreiveCustomer(int customerId) throws CustomerException;
	public Customer deleteCustomerById(int customerId) throws CustomerException;
	public List<Customer> getAllCustomers();
	public Login findUser(String username , String password) throws CustomerException;
}
