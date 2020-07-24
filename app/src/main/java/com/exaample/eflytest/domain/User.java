package com.exaample.eflytest.domain;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("user_email")
	private String userEmail;

	@SerializedName("password")
	private String password;

	@SerializedName("user_mobile")
	private long userMobile;

	@SerializedName("id")
	private int id;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("username")
	private String username;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setUserEmail(String userEmail){
		this.userEmail = userEmail;
	}

	public String getUserEmail(){
		return userEmail;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUserMobile(long userMobile){
		this.userMobile = userMobile;
	}

	public long getUserMobile(){
		return userMobile;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}