package com.trillion.vcemployerservice.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the business database table.
 * 
 */
@Entity
@NamedQuery(name="Business.findAll", query="SELECT b FROM Business b")
public class Business implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESS_ID_GENERATOR", sequenceName="VC_RECORD_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESS_ID_GENERATOR")
	private Long id;

	private String cage;

	@Column(name="country_code")
	private String countryCode;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="debt_subject_to_offset")
	private Boolean debtSubjectToOffset;

	private String duns;

	@Column(name="duns_plus4")
	private String dunsPlus4;

	@Column(name="expiration_date")
	private Timestamp expirationDate;

	@Column(name="has_known_exclusion")
	private Boolean hasKnownExclusion;

	@Column(name="last_modified")
	private Timestamp lastModified;

	@Column(name="last_modified_by")
	private String lastModifiedBy;

	@Column(name="legal_business_name")
	private String legalBusinessName;

	@Column(name="sam_address_city")
	private String samAddressCity;

	@Column(name="sam_address_line1")
	private String samAddressLine1;

	@Column(name="sam_address_state_or_province")
	private String samAddressStateOrProvince;

	@Column(name="sam_address_zip")
	private String samAddressZip;

	@Column(name="sam_address_zip4")
	private String samAddressZip4;

	private String status;

	public Business() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCage() {
		return this.cage;
	}

	public void setCage(String cage) {
		this.cage = cage;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getDebtSubjectToOffset() {
		return this.debtSubjectToOffset;
	}

	public void setDebtSubjectToOffset(Boolean debtSubjectToOffset) {
		this.debtSubjectToOffset = debtSubjectToOffset;
	}

	public String getDuns() {
		return this.duns;
	}

	public void setDuns(String duns) {
		this.duns = duns;
	}

	public String getDunsPlus4() {
		return this.dunsPlus4;
	}

	public void setDunsPlus4(String dunsPlus4) {
		this.dunsPlus4 = dunsPlus4;
	}

	public Timestamp getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Boolean getHasKnownExclusion() {
		return this.hasKnownExclusion;
	}

	public void setHasKnownExclusion(Boolean hasKnownExclusion) {
		this.hasKnownExclusion = hasKnownExclusion;
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

	public String getLegalBusinessName() {
		return this.legalBusinessName;
	}

	public void setLegalBusinessName(String legalBusinessName) {
		this.legalBusinessName = legalBusinessName;
	}

	public String getSamAddressCity() {
		return this.samAddressCity;
	}

	public void setSamAddressCity(String samAddressCity) {
		this.samAddressCity = samAddressCity;
	}

	public String getSamAddressLine1() {
		return this.samAddressLine1;
	}

	public void setSamAddressLine1(String samAddressLine1) {
		this.samAddressLine1 = samAddressLine1;
	}

	public String getSamAddressStateOrProvince() {
		return this.samAddressStateOrProvince;
	}

	public void setSamAddressStateOrProvince(String samAddressStateOrProvince) {
		this.samAddressStateOrProvince = samAddressStateOrProvince;
	}

	public String getSamAddressZip() {
		return this.samAddressZip;
	}

	public void setSamAddressZip(String samAddressZip) {
		this.samAddressZip = samAddressZip;
	}

	public String getSamAddressZip4() {
		return this.samAddressZip4;
	}

	public void setSamAddressZip4(String samAddressZip4) {
		this.samAddressZip4 = samAddressZip4;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}