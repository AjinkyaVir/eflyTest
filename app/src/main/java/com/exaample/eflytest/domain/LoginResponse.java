package com.exaample.eflytest.domain;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("result")
	private Result result;

	@SerializedName("message")
	private String message;

	@SerializedName("value")
	private String value;

	public Result getResult(){
		return result;
	}

	public String getMessage(){
		return message;
	}

	public String getValue(){
		return value;
	}
}