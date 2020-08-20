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
	@Table(name="Address1_tbl")

    public class Address {
		@Id
		@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
		@SequenceGenerator(name="mygen",sequenceName="Addss_seq",allocationSize=1)
		@Column(name="address_id")
		private int addressId;
		
		@Column(name="adoor",length=15)
		private String addressDoor;
		
		@Column(name="acity",length=15)
	    private String addressCity;
		
		@Column(name="astate",length=15)
		private String addressState;
		
		@Column(name="azip",length=15)
		private String addressZip;
		
		@ManyToOne
		@JoinColumn(name="customer_id")
		
	 private Customer customer; 
		
		//getters and setters

		public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

		public String getAddressDoor() {
			return addressDoor;
		}

		public void setAddressDoor(String addressDoor) {
			this.addressDoor = addressDoor;
		}

		public String getAddressCity() {
			return addressCity;
		}

		public void setAddressCity(String addressCity) {
			this.addressCity = addressCity;
		}

		public String getAddressState() {
			return addressState;
		}

		public void setAddressState(String addressState) {
			this.addressState = addressState;
		}



		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public String getAddressZip() {
			return addressZip;
		}

		public void setAddressZip(String addressZip) {
			this.addressZip = addressZip;
		}

		public Address(int addressId, String addressDoor, String addressCity, String addressState, String addressZip) {
			super();
			this.addressId = addressId;
			this.addressDoor = addressDoor;
			this.addressCity = addressCity;
			this.addressState = addressState;
			this.addressZip = addressZip;
		}

		public Address() {
			super();
		}
		
	
		
		
}

