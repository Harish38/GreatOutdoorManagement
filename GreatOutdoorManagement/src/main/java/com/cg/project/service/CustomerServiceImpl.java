package com.cg.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.dao.CustomerDao;
import com.cg.project.dao.LoginDao;
import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.entity.Login;
import com.cg.project.exception.AddressException;
import com.cg.project.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerDao customerdao;
	@Autowired
	LoginDao dao;
	
	@Override
	public Customer createCustomer(Customer customer) {
	
		return customerdao.saveAndFlush(customer);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer cust) throws CustomerException {
		if(! customerdao.existsById(customerId))
		{
			throw new CustomerException ("Id not found");
			
		}
		return customerdao.saveAndFlush(cust);
		}

	@Override
	public Customer RetreiveCustomer(int customerId) throws CustomerException {
		if(! customerdao.existsById(customerId))
		{
			throw new CustomerException ("Id not found");
			
		}
		return customerdao.findById(customerId).get();
	}

	@Override
	public Customer deleteCustomerById(int customerId) throws CustomerException {
		Customer customer= null;
		if(! customerdao.existsById(customerId))
		{
			throw new CustomerException ("Id not found");
			
		}
		else
		{
			customer=customerdao.findById(customerId).get();
			customerdao.deleteById(customerId);
		}
		return customer;
	}

	

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerdao.findAll( );
	}

	@Override
	public Login findUser(String username, String password) throws CustomerException {
		
		return dao.findUser(username, password);
	}

	
}
