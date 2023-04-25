package com.example.smart_ration_shop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class home extends AppCompatActivity {
    ImageView add,notify,profile,update,delete,logout;
    String name,email,username,password,udate,uphone;
    Toolbar toolbar;
    TextView tv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        name=getIntent().getStringExtra("name");

        if (actionBar != null) {
            actionBar.hide();
        }
        setContentView(R.layout.activity_home);
        tv = findViewById(R.id.tvUsernameHome);
        tv.setText("Hello , "+name);
        add = findViewById(R.id.add);
        profile = findViewById(R.id.profile);
        logout = findViewById(R.id.logout1);
        update = findViewById(R.id.info);
        notify = findViewById(R.id.notify);
        delete = findViewById(R.id.stock);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, profile.class);
                intent.putExtra("name", name);
//                intent.putExtra("email", email);
//                intent.putExtra("username", username);
//                intent.putExtra("password", password);
//                intent.putExtra("udate",udate);
//                intent.putExtra("uphone",uphone);
                startActivity(intent);
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(home.this,Notification.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,login.class);

                startActivity(intent);
                finish();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,MainActivity.class);
                startActivity(intent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,about_us.class);
                startActivity(intent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,sss.class);
                startActivity(intent);
            }
        });




    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}