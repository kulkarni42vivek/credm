package com.credm.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credm.test.models.Vendor;

public interface VendorRepo extends JpaRepository<Vendor, Long> {

}