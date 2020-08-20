package com.cg.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.Customer;
import com.cg.project.entity.Login;
import com.cg.project.exception.CustomerException;
import com.cg.project.service.CustomerService;
@RestController
@CrossOrigin("*")

public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	/******************************************
    - Method Name      : getAllCustomers
    - Input Parameters : Customer Bean
    - Return type      : ResponseEntity
    - End Point Url    : /customer
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching of Customer Bean class from Database. 
     ******************************************/
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomers() 
	{
		List<Customer> list = customerService.getAllCustomers();
		ResponseEntity<List<Customer>>  responseEntity = new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
		return responseEntity;
			}
	
	/******************************************
    - Method Name      : findAllCustomerId
    - Input Parameters : customer Bean
    - Return type      : ResponseEntity
    - End Point Url    : /customer/{id}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching of Customer Bean class from Database by Id. 
     ******************************************/
	
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> findAllCustomerId(@PathVariable("id")  int id) throws CustomerException 	{
		Customer customer = customerService.RetreiveCustomer(id);
		   ResponseEntity<Customer>  responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);
		   return responseEntity;
		}
	
	/******************************************
    - Method Name      : createCustomer
    - Input Parameters : Customer Bean
    - Return type      : ResponseEntity
    - End Point Url    : /customer
    -Request Method Type:  PostMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Inserting the Address information entered by customer into the database.
     ******************************************/

	
	@PostMapping("customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) 
	{
		customer.setCustomerName(customer.getCustomerName());
		Customer customers = customerService.createCustomer(customer);
		ResponseEntity<Customer>  responseEntity = new ResponseEntity<Customer>(customers,HttpStatus.OK);
            return responseEntity;
	}
	
	/******************************************
    - Method Name      : deleteCustomerById
    - Input Parameters : Customer Bean
    - Return type      : ResponseEntity
    - End Point Url    : /customer/{id}
    -Request Method Type:  DeleteMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Deleting the Address Id entered by customer from the database.
     ******************************************/
	
	@DeleteMapping("customer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int customerId) throws CustomerException
	{

		ResponseEntity<Customer>  responseEntity = null;
		Customer customer = customerService.deleteCustomerById(customerId);
		responseEntity= new ResponseEntity<Customer>(customer,HttpStatus.OK);
		
		return responseEntity;
	}
	
	/******************************************
    - Method Name      : updateCustomer
    - Input Parameters : Customer Bean
    - Return type      : ResponseEntity
    - End Point Url    : /customer/customerId/{id}
    -Request Method Type: PutMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Updating the Customer Id entered by customer from the database.
     ******************************************/
	@PutMapping("customer/customerId/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerId,@RequestBody Customer customer) throws CustomerException
	{
		customer.setCustomerName(customer.getCustomerName());
		Customer customers = customerService.updateCustomer(customerId, customer);
		ResponseEntity<Customer>  responseEntity = new ResponseEntity<Customer>(customers,HttpStatus.OK);

		return responseEntity;
	}
	
	/******************************************
    - Method Name      : findUserLogin
    - Input Parameters : Login Bean
    - Return type      : ResponseEntity
    - End Point Url    : /admin/login/{user}/{pass}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching the data of password and username of customer from database.
     ******************************************/
	
	@GetMapping("admin/login/{user}/{pass}")
	public ResponseEntity<Login>  findUserLogin(@PathVariable("user") String username, @PathVariable("pass") String password) throws CustomerException
	{
	  
		 Login log = customerService.findUser(username,password);
		 if(log==null) {
			 throw new CustomerException("Login not successful");
		 }
		 return new ResponseEntity<>(log,HttpStatus.OK);
		
		
	}
}
