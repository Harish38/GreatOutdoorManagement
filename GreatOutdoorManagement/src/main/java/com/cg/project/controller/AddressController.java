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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.exception.AddressException;
import com.cg.project.service.AddressService;

/******************************************
- File Name      : AddressController.java
- Author           : Capgemini
- Creation Date    : 11-08-2020
- Description      : This Controller class act as an end point to manage the entire AddressService
 ******************************************/

@RestController
@CrossOrigin("*")

public class AddressController {

	@Autowired
	AddressService addressService;
	
	/******************************************
    - Method Name      : findAllAddress
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching of Address Bean class from Database. 
     ******************************************/

	@GetMapping("address")
	public ResponseEntity<List<Address>> findAllAddress() throws AddressException {
		List<Address> list = addressService.findAllAddress();
		ResponseEntity<List<Address>> responseEntity = new ResponseEntity<List<Address>>(list, HttpStatus.OK);
		return responseEntity;
	}
	
	/******************************************
    - Method Name      : findAllAddressId
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address/{id}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching of Address Bean class from Database by Id. 
     ******************************************/

	@GetMapping("address/{id}")
	public ResponseEntity<Address> findAllAddressId(@PathVariable("id") int id) throws AddressException {
		Address addresses = addressService.findAllAddressId(id);
		ResponseEntity<Address> responseEntity = new ResponseEntity<>(addresses, HttpStatus.OK);
		return responseEntity;

	}
	
	/******************************************
    - Method Name      : createAddress
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address/customer/{id}
    -Request Method Type:  PostMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Inserting the Address information entered by customer into the database.
     ******************************************/

	@PostMapping("address/customer/{id}")
	public ResponseEntity<Address> createAddress(@PathVariable("id") int customerId, @RequestBody Address address)
			throws AddressException {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		address.setCustomer(customer);
		Address addr = addressService.createAddress(address);
		ResponseEntity<Address> responseEntity = new ResponseEntity<Address>(addr, HttpStatus.OK);

		return responseEntity;
	}
	
	/******************************************
    - Method Name      : deleteAddressById
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address/{id}
    -Request Method Type:  DeleteMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Deleting the Address Id entered by customer from the database.
     ******************************************/

	@DeleteMapping("address/{id}")
	public ResponseEntity<Address> deleteAddressById(@PathVariable("id") int addressId) throws AddressException {

		ResponseEntity<Address> responseEntity = null;

		Address re = addressService.deleteAddressById(addressId);
		responseEntity = new ResponseEntity<Address>(re, HttpStatus.OK);

		return responseEntity;
	}
	
	/******************************************
    - Method Name      : updateAddress
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address/addressId/{id}
    -Request Method Type: PutMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Updating the Address Id entered by customer from the database.
     ******************************************/


	@PutMapping("address/addressId/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") int addressId, @RequestBody Address address)
			throws AddressException {
		address.setAddressDoor(address.getAddressDoor());
		address.setAddressCity(address.getAddressCity());
		address.setAddressState(address.getAddressState());
		address.setAddressZip(address.getAddressZip());
		Address addr = addressService.updateAddress(addressId, address);
		ResponseEntity<Address> responseEntity = new ResponseEntity<Address>(addr, HttpStatus.OK);

		return responseEntity;
	}
	
	/******************************************
    - Method Name      : getAllAddressOfCustomer
    - Input Parameters : Address Bean
    - Return type      : ResponseEntity
    - End Point Url    : /address/customer/{id}
    -Request Method Type: GetMapping
    - Author           : Capgemini
    - Creation Date    : 11-08-2020
    - Description      : Fetching of Customer Bean class from Database by Id. 
     ******************************************/

	@GetMapping("address/customer/{id}")
	public ResponseEntity<List<Address>> getAllAddressOfCustomer(@PathVariable("id") int customerId) {
		List<Address> list = addressService.getAllAdressOfCustomer(customerId);
		ResponseEntity<List<Address>> responseEntity = new ResponseEntity<List<Address>>(list, HttpStatus.OK);
		return responseEntity;
	}
}
