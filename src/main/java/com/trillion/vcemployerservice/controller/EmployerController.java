package com.trillion.vcemployerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trillion.vcemployerservice.dto.SamBusiness;
import com.trillion.vcemployerservice.service.EmployerService;

@RestController
@RequestMapping("/")
public class EmployerController {
	
	@Autowired
	EmployerService employerService;
	
	@GetMapping(path = "/searchSam/{sessionId}", produces = "application/json")
	ResponseEntity<List<SamBusiness>> searchSam(@PathVariable String sessionId, @RequestParam("businessName") String businessName) {

		return ResponseEntity.ok().body(employerService.searchSam(businessName));

	}
}
