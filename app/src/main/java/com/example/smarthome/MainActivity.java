package com.example.smarthome;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button btnRoom1, btnRoom2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRoom1 = (Button) findViewById(R.id.btnRoom1);
        btnRoom2 = (Button) findViewById(R.id.btnRoom2);
    }

    public void AcessRoom1(View view) {
        Intent intent = new Intent(MainActivity.this, Room1Activity.class);
        startActivity(intent);
    }

    public void AcessRoom2(View view) {
        Intent intent = new Intent(MainActivity.this, Room2Activity.class);
        startActivity(intent);
    }
}
