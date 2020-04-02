package com.trillion.vcemployerservice.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trillion.vcemployerservice.dto.Job;
import com.trillion.vcemployerservice.dto.SamBusiness;
import com.trillion.vcemployerservice.exception.VetChallengeServiceException;
import com.trillion.vcemployerservice.service.EmployerService;

@Service
public class EmployerServiceImpl implements EmployerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${sam.api.url}")
	private String samApiUrl;

	@Value("${sam.api.key}")
	private String samApiKey;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<SamBusiness> searchSam(String businessName) {
		try {
			String samResponse = restTemplate.getForObject(buildSamApiRequestUrl(businessName), String.class);
			return parseAndGetSamBusinesses(samResponse);
			
		} catch(Exception e) {
			logger.error("Error while calling sam api - {}", e.getMessage());
			throw new VetChallengeServiceException("Unable to serve your request.");
		}		
	}

	private String buildSamApiRequestUrl(String businessName) {
		StringBuilder samApiRequestBuilder = new StringBuilder();
		samApiRequestBuilder.append(samApiUrl).append("legalBusinessName:(").append(businessName.replaceAll(" ", ",+"))
				.append(")+AND+registrationStatus:A&start=1&length=25").append("&api_key=").append(samApiKey);
		logger.info(samApiRequestBuilder.toString());
		return samApiRequestBuilder.toString();
	}

	public List<SamBusiness> parseAndGetSamBusinesses(String json) throws JsonMappingException, JsonProcessingException {
		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = mapper.readTree(json);
		JsonNode results = rootNode.path("results");
		List<SamBusiness> samBusinesses = new ArrayList<>();
		if (results.isArray()) {
			for (JsonNode result : results) {
				SamBusiness samBusiness = new SamBusiness();
				samBusiness.setCage(result.path("cage").asText());
				samBusiness.setDuns(result.path("duns").asText());
				samBusiness.setDunsPlus4(result.path("duns_plus4").asText());
				samBusiness.setLegalBusinessName(result.path("legalBusinessName").asText());
				samBusiness.setStatus(result.path("status").asText());
				JsonNode samAddress = result.path("samAddress");
				samBusiness.setAddressLine1(samAddress.path("line1").asText());
				samBusiness.setCity(samAddress.path("city").asText());
				samBusiness.setStateOrProvince(samAddress.path("stateOrProvince").asText());
				samBusiness.setCountryCode(samAddress.path("countryCode").asText());
				samBusiness.setZip(samAddress.path("zip").asText());
				samBusiness.setZip4(samAddress.path("zip4").asText());
				samBusinesses.add(samBusiness);
				
			}
		}
		
		return samBusinesses;
	}

	@Override
	public List<Job> getJobsPosted(Long employerId) {
		int jobsCount = getRandomInteger(50, 1);
		List<Job> jobs = new ArrayList<>();
		for (int i = 0; i < jobsCount; i++ ) {
			Job job = new Job();
			job.setJobId(i + 1000L);
			job.setEmployerImage("https://react.semantic-ui.com/images/avatar/large/steve.jpg");
			Long jobRoleId = Long.valueOf(getRandomInteger(5, 1));
			job.setJobRoleId(jobRoleId);
			job.setJobRole(getJobRole(jobRoleId));
			job.setEmployerName("Leidos");
			job.setLocation(getRandomLocation());
			job.setViewsCount(getRandomInteger(1000, 1));
			job.setApplicantsCount(getRandomInteger(100, 1));
			Calendar cal = Calendar.getInstance();
			job.setJobPosted(datesBetween(getMinimumDate(), new Date()));
			jobs.add(job);
		}
		return jobs;
	}
	
	private Date getMinimumDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -30);
		Date dateBefore30Days = cal.getTime();
		return dateBefore30Days;
	}
	
	private String getRandomLocation() {
		String[] locations = {"Washington D.C", "New York", "New Jersey", "Hyderabad", "Banglore", "Deleware"};
		int rnd = new Random().nextInt(locations.length);
	    return locations[rnd];
	}
	
	public static Date datesBetween(Date startInclusive, Date endExclusive) {
	    long startMillis = startInclusive.getTime();
	    long endMillis = endExclusive.getTime();
	    long randomMillisSinceEpoch = ThreadLocalRandom
	      .current()
	      .nextLong(startMillis, endMillis);
	 
	    return new Date(randomMillisSinceEpoch);
	}
	
	private String getJobRole(Long jobRoleId) {
		if (jobRoleId == 1) {
			return "Software Engineer";
		} else if (jobRoleId == 2) {
			return "Associate";
		} else if (jobRoleId == 3) {
			return "Junior Associate";
		} else if (jobRoleId == 4) {
			return "Senior Software Engineer";
		} else if (jobRoleId == 5) {
			return "Associate Manager";
		} else if (jobRoleId == 6) {
			return "Team Lead";
		} else if (jobRoleId == 7) {
			return "Solution Architect";
		} else if (jobRoleId == 8) {
			return "Project Manager";
		} else {
			return "";
		}
	}
	
	public static Integer getRandomInteger(int maximum, int minimum){ 
		return ((int) (Math.random()*(maximum - minimum))) + minimum; 
	}

	
	
}
