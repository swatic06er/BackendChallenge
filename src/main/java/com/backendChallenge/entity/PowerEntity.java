package com.backendChallenge.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="PowerData")
public class PowerEntity {

	
	private String name;
	
	
	
	@Id
	@Column(name = "postcode")
	private String postcode;
	
	private int capacity;
   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPostcode() {
		return postcode;
	}
	public PowerEntity(String name) {
		super();
		this.name = name;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	 public PowerEntity(String name, String postcode, int capacity) {
			super();
			this.name = name;
			this.postcode = postcode;
			this.capacity = capacity;
		}
	 public PowerEntity() {}
	 
	
}
