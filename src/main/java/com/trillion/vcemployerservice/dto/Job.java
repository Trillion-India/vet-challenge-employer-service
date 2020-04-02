package com.trillion.vcemployerservice.dto;

import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6574469200924992020L;
	
	private Long JobId;
	private String employerImage;
	private Long jobRoleId;
	private String jobRole;
	private String employerName;
	private String location;
	private Integer viewsCount;
	private Integer applicantsCount;
	private Date jobPosted;
	
	public Long getJobId() {
		return JobId;
	}
	public void setJobId(Long jobId) {
		JobId = jobId;
	}
	public String getEmployerImage() {
		return employerImage;
	}
	public void setEmployerImage(String employerImage) {
		this.employerImage = employerImage;
	}
	public Long getJobRoleId() {
		return jobRoleId;
	}
	public void setJobRoleId(Long jobRoleId) {
		this.jobRoleId = jobRoleId;
	}
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getViewsCount() {
		return viewsCount;
	}
	public void setViewsCount(Integer viewsCount) {
		this.viewsCount = viewsCount;
	}
	public Integer getApplicantsCount() {
		return applicantsCount;
	}
	public void setApplicantsCount(Integer applicantsCount) {
		this.applicantsCount = applicantsCount;
	}
	public Date getJobPosted() {
		return jobPosted;
	}
	public void setJobPosted(Date jobPosted) {
		this.jobPosted = jobPosted;
	}
}
