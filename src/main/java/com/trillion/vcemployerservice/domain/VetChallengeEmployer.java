package com.trillion.vcemployerservice.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vet_challenge_employer database table.
 * 
 */
@Entity
@Table(name="vet_challenge_employer")
@NamedQuery(name="VetChallengeEmployer.findAll", query="SELECT v FROM VetChallengeEmployer v")
public class VetChallengeEmployer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VET_CHALLENGE_EMPLOYER_ID_GENERATOR", sequenceName="VC_RECORD_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VET_CHALLENGE_EMPLOYER_ID_GENERATOR")
	private Long id;

	@Column(name="business_id")
	private Long businessId;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_logged_in")
	private Timestamp lastLoggedIn;

	@Column(name="last_modified")
	private Timestamp lastModified;

	@Column(name="last_modified_by")
	private String lastModifiedBy;

	@Column(name="last_name")
	private String lastName;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	private String username;

	@Column(name="work_email")
	private String workEmail;

	public VetChallengeEmployer() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Timestamp getLastLoggedIn() {
		return this.lastLoggedIn;
	}

	public void setLastLoggedIn(Timestamp lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

	public Timestamp getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public String getLastModifiedBy() {
		return this.lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

}