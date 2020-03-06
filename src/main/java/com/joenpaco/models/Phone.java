package com.joenpaco.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	private String number;

	private String citycode;

	private String countrycode;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long PhoneId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Long getPhoneId() {
		return PhoneId;
	}

	public void setPhoneId(Long PhoneId) {
		this.PhoneId = PhoneId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
