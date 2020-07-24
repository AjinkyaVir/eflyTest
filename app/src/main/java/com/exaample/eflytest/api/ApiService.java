package com.exaample.eflytest.api;


import com.exaample.eflytest.domain.LoginResponse;
import com.exaample.eflytest.domain.Result;
import com.exaample.eflytest.domain.User;
import com.exaample.eflytest.domain.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Ajinkya on 7/22/2020.
 */
public interface ApiService {

    //http://eflytest.work/API/backend/Auth/userRegister

    @POST("userRegister")
    Call<UserResponse> saveProvider(@Body User saveUser);

    //http://eflytest.work/API/backend/Auth/getLoginData
    @POST("getLoginData")
    Call<LoginResponse> userLogin(@Body Result getLoginData);

    //http://eflytest.work/API/backend/Auth/userUpdateProfile
    @POST("userUpdateProfile")
    Call<User> updateUser(@Body User udpdatedProfile);

}
