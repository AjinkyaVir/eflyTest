package com.exaample.eflytest;

import androidx.appcompat.app.AppCompatActivity;

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
import com.exaample.eflytest.domain.User;
import com.exaample.eflytest.domain.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {

    EditText edtUserName,edtEmail,edtMobile,edtPassword;
    TextView txtId;
    Button btnUpdate;
    private RetrofitClient retrofitClient = new RetrofitClient();
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

      /*  Bundle bundle = getIntent().getExtras();
        id = bundle.getString("ID");
        Toast.makeText(this, "ID === >>> " + id, Toast.LENGTH_SHORT).show();*/

        edtUserName = findViewById(R.id.edtChangeUsername);
        edtEmail = findViewById(R.id.edtUpdateEmail);
        edtMobile = findViewById(R.id.edtUpdateMobile);
        edtPassword = findViewById(R.id.edtConfirmPassword);

        txtId = findViewById(R.id.txtId);

        btnUpdate = findViewById(R.id.btnUpdateProfile);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
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
        else if (edtEmail.getText().toString().isEmpty()){
            edtEmail.setError("Enter Email ID");
        }
        else if (edtMobile.getText().toString().isEmpty()){
            edtMobile.setError("Enter mobile number");
        }
        else if (edtPassword.getText().toString().isEmpty()){
            edtPassword.setError("Enter Password");
        }
        else {
            updateProfile();
        }

    }

    private void updateProfile() {

        ApiService service = retrofitClient.getRetrofitInstance(EditProfile.this).create(ApiService.class);
        Call<User> userCall = service.updateUser(updateUser());
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(EditProfile.this, "Profile Updated successfully", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

    }

    private User updateUser() {
        User updateUser = new User();
        updateUser.setId(Integer.parseInt(id));
        updateUser.setUsername(edtUserName.getText().toString());
        updateUser.setUserEmail(edtEmail.getText().toString());
        updateUser.setPassword(edtPassword.getText().toString());
        return updateUser;
    }
}
