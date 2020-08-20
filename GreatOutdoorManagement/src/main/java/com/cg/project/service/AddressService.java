package com.cg.project.service;

import java.util.List;

import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.exception.AddressException;




public interface AddressService {
	
	
	public List<Address>  findAllAddress() throws AddressException;
	public Address  findAllAddressId(int addressId) throws AddressException;
	public Address createAddress(Address address);
	public Address updateAddress(int addressId, Address address) throws AddressException;
	public Address deleteAddressById(int addressId) throws AddressException;
	public List<Address> getAllAdressOfCustomer(int customerId) ;
	
	
	
	
	


	



	



}
