package com.exaample.eflytest.domain;

import com.google.gson.annotations.SerializedName;

public class Result{

	@SerializedName("password")
	private String password;

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("user_mobile")
	private String userMobile;

	@SerializedName("user_city")
	private Object userCity;

	@SerializedName("id")
	private String id;

	@SerializedName("user_profile")
	private Object userProfile;

	@SerializedName("user_location")
	private Object userLocation;

	@SerializedName("username")
	private String username;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("status")
	private String status;

	public String getPassword(){
		return password;
	}

	public String getFirstname(){
		return firstname;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public String getUserMobile(){
		return userMobile;
	}

	public Object getUserCity(){
		return userCity;
	}

	public String getId(){
		return id;
	}

	public Object getUserProfile(){
		return userProfile;
	}

	public Object getUserLocation(){
		return userLocation;
	}

	public String getUsername(){
		return username;
	}

	public String getLastname(){
		return lastname;
	}

	public String getStatus(){
		return status;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public void setUserCity(Object userCity) {
		this.userCity = userCity;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUserProfile(Object userProfile) {
		this.userProfile = userProfile;
	}

	public void setUserLocation(Object userLocation) {
		this.userLocation = userLocation;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}