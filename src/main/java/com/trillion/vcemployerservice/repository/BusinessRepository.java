package com.trillion.vcemployerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trillion.vcemployerservice.domain.Business;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {
	
}
