package com.cg.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.project.dao.AddressDao;
import com.cg.project.dao.CustomerDao;
import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;
import com.cg.project.exception.AddressException;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressDao addressdao;
	@Override
	public List<Address> findAllAddress() throws AddressException {
	return addressdao.findAll();
	}

	@Override
	public Address findAllAddressId(int addressId) throws AddressException {
	if(! addressdao.existsById(addressId))
	{
		throw new AddressException ("Id not found");
		
	}
	return addressdao.findById(addressId).get();
	}

	@Override
	public Address createAddress(Address address) {
		return  addressdao.saveAndFlush(address);
		}

	@Override
	public Address updateAddress(int addressId, Address address) throws AddressException {
		if(! addressdao.existsById(addressId))
		{
			throw new AddressException ("Id not found");
			
		}
		return addressdao.saveAndFlush(address);
	}

	@Override
	public Address deleteAddressById(int addressId) throws AddressException {
	Address address = null;
	
		if(! addressdao.existsById(addressId))
		{
			throw new AddressException ("Id not found");
			
		}
		else
		{
			address=addressdao.findById(addressId).get();
			addressdao.deleteById(addressId);
		}
		return address;
	}

	@Override
	public List<Address> getAllAdressOfCustomer(int customerId) {
		
		return addressdao.getAllAdressOfCustomer(customerId);
	}
		}


