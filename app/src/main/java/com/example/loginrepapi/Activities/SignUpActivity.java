package com.example.loginrepapi.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginrepapi.Interfaces.SignupDataService;
import com.example.loginrepapi.R;
import com.example.loginrepapi.SignUpClientInstance;
import com.example.loginrepapi.Requests.SignupDataModel;
import com.example.loginrepapi.Responses.SignupResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText username;
    EditText email;
    EditText password;
    EditText c_password;
    Button signin_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    private void init() {
        username = findViewById(R.id.uname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        c_password = findViewById(R.id.confpass);
        signin_button = findViewById(R.id.button);
        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
            }
        });
    }

    private void signin() {
        SignupDataModel signupDataModel=new SignupDataModel(1,username.getText().toString()
                ,email.getText().toString(),password.getText().toString(),c_password.getText().toString());
        SignupDataService service = SignUpClientInstance.getRetrofit().create(SignupDataService.class);
        Call<SignupResponse> call = service.getAllposts(signupDataModel);
        call.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                SignupResponse signupResponse = response.body();
                if (response.isSuccessful() && signupResponse != null && signupResponse.getData() != null) {
                    String studentid = signupResponse.getData().get(0).getStudent_id();
                    Toast.makeText(getApplicationContext(), "Student id--" + studentid, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Signup Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
