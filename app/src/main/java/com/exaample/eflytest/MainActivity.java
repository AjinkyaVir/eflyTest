package com.exaample.eflytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.exaample.eflytest.api.ApiService;
import com.exaample.eflytest.api.RetrofitClient;
import com.exaample.eflytest.domain.LoginResponse;
import com.exaample.eflytest.domain.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin,btnSignUp;
    EditText edtUserName,edtPassword;
    TextView txtForgotPassword;
    private RetrofitClient retrofitClient = new RetrofitClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        txtForgotPassword = findViewById(R.id.txtForgetPassword);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });

    }


    private void checkValidation() {

        if (edtUserName.getText().toString().isEmpty()){
            edtUserName.setError("Enter Username");
        }
        else if (edtPassword.getText().toString().isEmpty()){
            edtPassword.setError("Enter Password");
        }
        else {
            login();
        }

    }

    private void login() {

        ApiService service = retrofitClient.getRetrofitInstance(MainActivity.this).create(ApiService.class);
        Call<LoginResponse> userResponseCall = service.userLogin(getLoginData());
        userResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i("@ajinkya","login success ==>>  " + response.body().getResult().getUsername());
                Log.i("@ajinkya","login success ==>>  " + response.body().getResult().getId());
                //Toast.makeText(MainActivity.this, "login success ==>>", Toast.LENGTH_SHORT).show();

                if (response.code() == 200){
                    /*Intent intent = new Intent(getApplicationContext(),EditProfile.class);
                    intent.putExtra("ID",response.body().getResult().getId());
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));*/
                    Intent intent = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    private Result getLoginData() {
        Result user = new Result();
        user.setUsername(edtUserName.getText().toString());
        user.setPassword(edtPassword.getText().toString());
        return user;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}
