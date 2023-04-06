package com.example.smart_ration_shop;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Notification extends AppCompatActivity {
    private EditText number,msg;
    private Button btn;

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        number = findViewById(R.id.editTextNumber);
        msg = findViewById(R.id.msgName);
        btn = findViewById(R.id.button123);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check for permission to send SMS messages
                if (ContextCompat.checkSelfPermission(Notification.this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {

                        sendSMS();


                } else {
                    ActivityCompat.requestPermissions(Notification.this,
                            new String[]{Manifest.permission.SEND_SMS},
                            MY_PERMISSIONS_REQUEST_SEND_SMS);

                }
            }
        });




    }

    private void sendSMS() {
        String phoneNumber = number.getText().toString(); // Replace with the phone number you want to send the message to
        String message = msg.getText().toString(); // Replace with the message you want to send

        SmsManager smsManager = SmsManager.getDefault();
        if(!(phoneNumber.isEmpty() || message.isEmpty())){
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);


            Toast.makeText(this, "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "please fill the correct phone number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted, send SMS message
                    sendSMS();
                } else {
                    // Permission denied
                    Toast.makeText(this, "Permission denied to send SMS", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
