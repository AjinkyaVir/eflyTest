package com.exaample.eflytest.domain;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("value")
	private String value;

	public String getMessage(){
		return message;
	}

	public String getValue(){
		return value;
	}
}