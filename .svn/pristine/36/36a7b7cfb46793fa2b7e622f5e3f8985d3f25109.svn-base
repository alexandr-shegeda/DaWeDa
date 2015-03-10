package com.daweda.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
@NamedQuery(name="UserDetails.findAll", query="SELECT u FROM UserDetails u")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(name="birth_date")
	private Timestamp birthDate;

	@Column(name="city", length=64)
	private String city;

	@Column(name="country", length=64)
	private String country;

	@Column(name="first_name", length=64)
	private String firstName;

	@Column(name="last_name", length=64)
	private String lastName;

	@Column(name="passport", length=11)
	private String passport;

	@Column(name="phone", length=32)
	private String phone;

	@Column(name="post_code", length=11)
	private String postCode;

	@Column(name="street", length=64)
	private String street;
	
	@Column(name="contact_email", length=128)
	private String contactEmail;

    //tracking ip on login
	@Column(name="ip", length=32)
	private String ip;
	
	@Column(name="geo_ip", length=32)
	private String geoIp;
	
	@Column(name="country_code")
	private String countryCode;
	
	public UserDetails() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassport() {
		return this.passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGeoIp() {
		return geoIp;
	}

	public void setGeoIp(String geoIp) {
		this.geoIp = geoIp;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", birthDate=" + birthDate + ", city="
				+ city + ", country=" + country + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", passport=" + passport
				+ ", phone=" + phone + ", postCode=" + postCode + ", street="
				+ street + ", contactEmail=" + contactEmail + ", users="
				+ "]";
	}

}