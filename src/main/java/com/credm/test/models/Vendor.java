package com.credm.test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vend_id")
	Long vendorId;
	
	private String name;
	private String email;
	private String upi;
}
