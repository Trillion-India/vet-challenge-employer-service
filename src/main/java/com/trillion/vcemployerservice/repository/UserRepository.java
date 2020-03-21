package com.trillion.vcemployerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trillion.vcemployerservice.domain.VetChallengeEmployer;

@Repository
public interface UserRepository  extends CrudRepository<VetChallengeEmployer, Long> {

}
