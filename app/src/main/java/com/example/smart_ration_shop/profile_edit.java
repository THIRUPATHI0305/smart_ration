package com.example.smart_ration_shop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile_edit extends AppCompatActivity {

    EditText editName, editEmail,editUsername, editPassword,editdob,editphone;
    Button saveButton;
    String nameUser, emailUser, usernameUser, passwordUser,DobUser,PhoneUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_profile_edit);

        reference = FirebaseDatabase.getInstance().getReference("users");

        editName = findViewById(R.id.pname);
        editEmail = findViewById(R.id.pemail);
        editUsername = findViewById(R.id.puser);
        editPassword = findViewById(R.id.ppassword);
        editdob = findViewById(R.id.pdate);
        editphone = findViewById(R.id.pphone);
        saveButton = findViewById(R.id.pbutton);

        showData();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNameChanged() || isPasswordChanged() || isEmailChanged()){
                    Toast.makeText(profile_edit.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(profile_edit.this, "No Changes Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isNameChanged() {
        if (!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser = editName.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailChanged() {
        if (!emailUser.equals(editEmail.getText().toString())){
            reference.child(usernameUser).child("email").setValue(editEmail.getText().toString());
            emailUser = editEmail.getText().toString();
            return true;
        } else {
            return false;
        }
    }


    private boolean isPasswordChanged() {
        if (!passwordUser.equals(editPassword.getText().toString())){
            reference.child(usernameUser).child("password").setValue(editPassword.getText().toString());
            passwordUser = editPassword.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isDobChanged() {
        if (!DobUser.equals(editdob.getText().toString())){
            reference.child(usernameUser).child("udate").setValue(editdob.getText().toString());
            DobUser = editdob.getText().toString();
            return true;
        } else {
            return false;
        }
    }
    private boolean isPhoneChanged() {
        if (!PhoneUser.equals(editphone.getText().toString())){
            reference.child(usernameUser).child("uphone").setValue(editphone.getText().toString());
            PhoneUser = editphone.getText().toString();
            return true;
        } else {
            return false;
        }
    }

    public void showData(){

        Intent intent = getIntent();

        nameUser = intent.getStringExtra("name");
        emailUser = intent.getStringExtra("email");
        passwordUser = intent.getStringExtra("password");
        usernameUser = intent.getStringExtra("username");
        DobUser = intent.getStringExtra("udate");
        PhoneUser = intent.getStringExtra("uphone");

        editName.setText(nameUser);
        editEmail.setText(emailUser);
        editUsername.setText(usernameUser);
        editdob.setText(DobUser);
        editphone.setText(PhoneUser);
        editPassword.setText(passwordUser);
    }
}