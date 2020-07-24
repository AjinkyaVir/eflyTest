package com.exaample.eflytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.exaample.eflytest.api.ApiService;
import com.exaample.eflytest.api.RetrofitClient;
import com.exaample.eflytest.domain.User;
import com.exaample.eflytest.domain.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {

    EditText edtFirstName,edtLastName,edtEmail,edtMobile,edtUsername,edtPassword;
    Button btnSignUp;
    private RetrofitClient retrofitClient = new RetrofitClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtMobile = findViewById(R.id.edtMobileNumber);
        edtEmail = findViewById(R.id.edtMail);
        edtUsername = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkValidation();
            }
        });
    }

    private void checkValidation() {
        if (edtFirstName.getText().toString().isEmpty()){
            edtFirstName.setError("Enter First name");
        }
        else if (edtLastName.getText().toString().isEmpty()){
            edtLastName.setError("Enter Last name");
        }
        else if (edtMobile.getText().toString().isEmpty()){
            edtMobile.setError("Enter Mobile number");
        }
        else if (edtEmail.getText().toString().isEmpty()){
            edtEmail.setError("Enter EmailId");
        }
        else if (edtUsername.getText().toString().isEmpty()){
            edtUsername.setError("Enter User Name");
        }
        else if (edtPassword.getText().toString().isEmpty()){
            edtPassword.setError("Enter Password");
        }
        else {
            saveUser();
        }
    }

    private void saveUser() {

        ApiService service = retrofitClient.getRetrofitInstance(SignUp.this).create(ApiService.class);
        Call<UserResponse> userResponseCall = service.saveProvider(getUserData());
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.i("@ajinkya","User register Success ====>>>>  " + response.body().getMessage());
                Log.i("@ajinkya","User register Success ====>>>>  " + response.message());
                if (response.code() == 200){
                    Toast.makeText(SignUp.this, "Dashboard Activity", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(intent);
                    /*startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
*/
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }

    private User getUserData() {
        User user = new User();
        user.setFirstname(edtFirstName.getText().toString());
        user.setLastname(edtLastName.getText().toString());
        user.setUserMobile(Long.parseLong(edtMobile.getText().toString()));
        user.setUserEmail(edtEmail.getText().toString());
        user.setUsername(edtUsername.getText().toString());
        user.setPassword(edtPassword.getText().toString());
        return user;

    }
}
