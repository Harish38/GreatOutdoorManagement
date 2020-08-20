package com.cg.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.cg.project.entity.Address;
import com.cg.project.entity.Customer;


@Repository
public interface AddressDao  extends JpaRepository<Address,Integer> {
	@Query (" FROM Address where customer.customerId=:id")
public List<Address> getAllAdressOfCustomer(@Param("id") int customerId);
}
