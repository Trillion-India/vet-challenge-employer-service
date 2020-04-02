package com.trillion.vcemployerservice.service;

import java.util.List;

import com.trillion.vcemployerservice.dto.Job;
import com.trillion.vcemployerservice.dto.SamBusiness;

public interface EmployerService {
	
	List<SamBusiness> searchSam(String businessName);

	List<Job> getJobsPosted(Long employerId);
}
