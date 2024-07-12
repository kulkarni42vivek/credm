package com.credm.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credm.test.models.EmailModel;

public interface EmailRepo extends JpaRepository<EmailModel, Long> {

}

