package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Room2Activity extends AppCompatActivity {
    Button BtnOn1, BtnOff1;
    ImageView img1,img2;
    TextView TimeDisplay1,TimeDisplay2;
    EditText TxtIp1,TxtIp2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2activity);

    }

    public void backmenu(View view) {
        Intent intent = new Intent(Room2Activity.this, MainActivity.class);
        startActivity(intent);
    }

    public void actionOn1(View view) {
    }
    public void actionOn2(View view) {
    }
    public void actionOn3(View view) {
    }
    public void actionOn4(View view) {
    }

    public void actionOff1(View view) {
    }
    public void actionOff2(View view) {
    }
    public void actionOff3(View view) {
    }
    public void actionOff4(View view) {
    }
}