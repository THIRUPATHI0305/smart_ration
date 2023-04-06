package com.example.smart_ration_shop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity{
    EditText signupName, signupUsername, signupEmail, signupPassword,date,phone;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_sign_up);
        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        date = findViewById(R.id.date);
        phone = findViewById(R.id.phone);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String udate = date.getText().toString();
                String uphone = phone.getText().toString();
                if(name.isEmpty() || email.isEmpty()|| username.isEmpty() || password.isEmpty() || udate.isEmpty() || uphone.isEmpty()){
                    Toast.makeText(SignupActivity.this, "please fill the all the details", Toast.LENGTH_SHORT).show();
                }else {
                    HelperClass helperClass = new HelperClass(name, email, username, password, udate, uphone);
                    reference.child(username).setValue(helperClass);
                    Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, login.class);
//                    intent.putExtra("name",name);
//                    intent.putExtra("email",email);
//                    intent.putExtra("username",username);
//                    intent.putExtra("password",password);
//                    intent.putExtra("udate",udate);
//                    intent.putExtra("uphone",uphone);
                    startActivity(intent);
                }
            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, login.class);
                startActivity(intent);
            }
        });
    }
}

