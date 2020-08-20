package com.cg.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



	@Entity
	@Table(name="customer_tbl")
	
	public class Customer {
		@Id
		@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
		
		@SequenceGenerator(name="mygen",sequenceName="cusst_seq",allocationSize=1)

		@Column(name="customer_id")
		private int customerId;
		
		@Column(name="customername",length=15)
		private String customerName;

		@OneToMany(mappedBy="customer")
		@JsonIgnore
		
		private List<Address> address = new ArrayList<>();
		
		//getters and setters
		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public List<Address> getAddress() {
			return address;
		}

		public void setAddress(List<Address> address) {
			this.address = address;
		}

		public Customer(int customerId, String customerName) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
		}

		public Customer() {
			super();
		}

	  
	}
		
		

