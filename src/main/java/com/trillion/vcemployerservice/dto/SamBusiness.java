package com.trillion.vcemployerservice.dto;

import java.io.Serializable;

public class SamBusiness implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6494737093224502268L;
	
	private String cage;
	private String duns;
	private String dunsPlus4;
	private String legalBusinessName;
	private String addressLine1;
	private String city;
	private String stateOrProvince;
	private String countryCode;
	private String zip;
	private String zip4;
	private String status;
	public String getCage() {
		return cage;
	}
	public void setCage(String cage) {
		this.cage = cage;
	}
	public String getDuns() {
		return duns;
	}
	public void setDuns(String duns) {
		this.duns = duns;
	}
	public String getDunsPlus4() {
		return dunsPlus4;
	}
	public void setDunsPlus4(String dunsPlus4) {
		this.dunsPlus4 = dunsPlus4;
	}
	public String getLegalBusinessName() {
		return legalBusinessName;
	}
	public void setLegalBusinessName(String legalBusinessName) {
		this.legalBusinessName = legalBusinessName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateOrProvince() {
		return stateOrProvince;
	}
	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip4() {
		return zip4;
	}
	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
