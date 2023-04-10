package com.example.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Room1Activity extends AppCompatActivity {
    DatabaseReference fdata;
    boolean bDevice1, timeisActive1 = false ,bDevice2, timeisActive2 = false,
            bDevice3, timeisActive3 = false, bDevice4, timeisActive4 = false;
    CountDownTimer countDownTimer1,countDownTimer2,countDownTimer3,countDownTimer4;
    Button BtnOn1, BtnOff1, BtnOn2, BtnOff2, BtnOn3, BtnOff3, BtnOn4, BtnOff4;
    ImageView img1,img2,img3,img4;
    TextView TimeDisplay1,TimeDisplay2,TimeDisplay3,TimeDisplay4;
    EditText TxtIp1,TxtIp2,TxtIp3,TxtIp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room1activity);
        BtnOn1 = (Button) findViewById(R.id.BtnOn1);
        BtnOff1 = (Button) findViewById(R.id.BtnOff1);

        BtnOn2 = (Button) findViewById(R.id.BtnOn2);
        BtnOff2 = (Button) findViewById(R.id.BtnOff2);

        BtnOn3 = (Button) findViewById(R.id.BtnOn3);
        BtnOff3 = (Button) findViewById(R.id.BtnOff3);

        BtnOn4 = (Button) findViewById(R.id.BtnOn4);
        BtnOff4 = (Button) findViewById(R.id.BtnOff4);
    //------------------------------------------------

        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);

        TimeDisplay1=(TextView) findViewById(R.id.Time1);
        TimeDisplay2=(TextView) findViewById(R.id.Time2);
        TimeDisplay3=(TextView) findViewById(R.id.Time3);
        TimeDisplay4=(TextView) findViewById(R.id.Time4);

        TxtIp1=(EditText) findViewById(R.id.TxtIp1);
        TxtIp2=(EditText) findViewById(R.id.TxtIp2);
        TxtIp3=(EditText) findViewById(R.id.TxtIp3);
        TxtIp4=(EditText) findViewById(R.id.TxtIp4);

        fdata= FirebaseDatabase.getInstance().getReference();

        fdata.child("Room1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int dev1 = snapshot.child("device1").getValue(Integer.class);
                int dev2 = snapshot.child("device2").getValue(Integer.class);
                int dev3 = snapshot.child("device3").getValue(Integer.class);
                int dev4 = snapshot.child("device4").getValue(Integer.class);
                if( dev1 ==1){
                    img1.setImageResource(R.drawable.deviceon);
                }else {
                    img1.setImageResource(R.drawable.deviceoff);
                }
                if( dev2 ==1){
                    img2.setImageResource(R.drawable.deviceon);
                    // BtAction1.setText("ON");
                }else {
                    img2.setImageResource(R.drawable.deviceoff);
                    //BtAction1.setText("OFF");
                }
                if( dev3 ==1){
                    img3.setImageResource(R.drawable.deviceon);
                }else {
                    img3.setImageResource(R.drawable.deviceoff);
                }
                if( dev4 ==1){
                    img4.setImageResource(R.drawable.deviceon);
                }else {
                    img4.setImageResource(R.drawable.deviceoff);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
//    Get data------------------------------------
//    <Event click---------------------------------
    //---dev 1
    public void actionOn1(View view) {
        bDevice1 = true;
        String Input = TxtIp1.getText().toString();
        if (timeisActive1){
            ResetTimer1();
        }else {
            if (Input.length()==0) {
                clickOn1();
                //timer1(Input);
            }
            else {
                BtnOn1.setText("Stop");
                BtnOff1.setEnabled(false);
                timeisActive1 = true;
                //clickOn1();
                timer1(Input);
            }
        }
    }
    private void clickOn1() {
        fdata.child("Room1").child("device1").setValue(1);
        img1.setImageResource(R.drawable.deviceon);
    }
    public void actionOff1(View view) {
        bDevice1 = false;
        String Input = TxtIp1.getText().toString();
        if (timeisActive1){
            ResetTimer1();
        }else {
            if (Input.length() == 0) {
                clickOff1();
            } else {
                BtnOff1.setText("Stop");
                BtnOn1.setEnabled(false);
                timeisActive1 = true;
                timer1(Input);
            }
        }
    }
    private void clickOff1() {
        fdata.child("Room1").child("device1").setValue(0);
        img1.setImageResource(R.drawable.deviceoff);
    }
    //---dev 2
    public void actionOn2(View view) {
        bDevice2 = true;
        String Input = TxtIp2.getText().toString();
        if (timeisActive2){
            ResetTimer2();
        }else {
            if (Input.length()==0) {
                clickOn2();
                //timer1(Input);
            }
            else {
                BtnOn2.setText("Stop");
                BtnOff2.setEnabled(false);
                timeisActive2 = true;
                //clickOn1();
                timer2(Input);
            }
        }
    }
    private void clickOn2() {
        fdata.child("Room1").child("device2").setValue(1);
        img2.setImageResource(R.drawable.deviceon);
    }
    public void actionOff2(View view) {
        bDevice2 = false;
        String Input = TxtIp2.getText().toString();
        if (timeisActive2){
            ResetTimer2();
        }else {
            if (Input.length() == 0) {
                clickOff2();
            } else {
                BtnOff2.setText("Stop");
                BtnOn2.setEnabled(false);
                timeisActive2 = true;
                timer2(Input);
            }
        }
    }
    private void clickOff2() {
        fdata.child("Room1").child("device2").setValue(0);
        img2.setImageResource(R.drawable.deviceoff);
    }
    //----dev 3
    public void actionOn3(View view) {
        bDevice3 = true;
        String Input = TxtIp3.getText().toString();
        if (timeisActive3){
            ResetTimer3();
        }else {
            if (Input.length()==0) {
                clickOn3();
                //timer1(Input);
            }
            else {
                BtnOn3.setText("Stop");
                BtnOff3.setEnabled(false);
                timeisActive3 = true;
                //clickOn1();
                timer3(Input);
            }
        }
    }
    private void clickOn3() {
        fdata.child("Room1").child("device3").setValue(1);
        img3.setImageResource(R.drawable.deviceon);
    }
    public void actionOff3(View view) {
        bDevice3 = false;
        String Input = TxtIp3.getText().toString();
        if (timeisActive3){
            ResetTimer3();
        }else {
            if (Input.length() == 0) {
                clickOff3();
            } else {
                BtnOff3.setText("Stop");
                BtnOn3.setEnabled(false);
                timeisActive3 = true;
                timer3(Input);
            }
        }
    }
    private void clickOff3() {
        fdata.child("Room1").child("device3").setValue(0);
        img3.setImageResource(R.drawable.deviceoff);
    }
    //----dev 4
    public void actionOn4(View view) {
        bDevice4 = true;
        String Input = TxtIp4.getText().toString();
        if (timeisActive4){
            ResetTimer4();
        }else {
            if (Input.length()==0) {
                clickOn4();
                //timer1(Input);
            }
            else {
                BtnOn4.setText("Stop");
                BtnOff4.setEnabled(false);
                timeisActive4 = true;
                //clickOn1();
                timer4(Input);
            }
        }
    }
    private void clickOn4() {
        fdata.child("Room1").child("device4").setValue(1);
        img4.setImageResource(R.drawable.deviceon);
    }
    public void actionOff4(View view) {
        bDevice4 = false;
        String Input = TxtIp4.getText().toString();
        if (timeisActive4){
            ResetTimer4();
        }else {
            if (Input.length() == 0) {
                clickOff4();
            } else {
                BtnOff4.setText("Stop");
                BtnOn4.setEnabled(false);
                timeisActive4 = true;
                timer4(Input);
            }
        }
    }
    private void clickOff4() {
        fdata.child("Room1").child("device4").setValue(0);
        img4.setImageResource(R.drawable.deviceoff);
    }
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Event click--------------------------------

// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Timer --------------------------------
    private void timer1(String Input) {
        TxtIp1.setVisibility(View.GONE);
        TimeDisplay1.setVisibility(View.VISIBLE);
        long miliInput = Long.parseLong(Input) * 60000;
        countDownTimer1 = new CountDownTimer(miliInput, 1000) {
            @Override
            public void onTick(long l) {updateTimer1((int) l/1000);}
            @Override
            public void onFinish() {
                if (bDevice1){
                    clickOn1();
                }else {
                    clickOff1();
                }
                ResetTimer1();
            }
        }.start();
    }
    public void updateTimer1(int secondsleft){
        int hours = secondsleft / 3600;
        int minutes = (secondsleft - hours * 3600) / 60;
        int seconds = secondsleft - (hours * 3600) - (minutes *60);
        TimeDisplay1.setText(hours + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }
    public void ResetTimer1(){
        TimeDisplay1.setVisibility(View.GONE);
        timeisActive1 = false;
        countDownTimer1.cancel();
        BtnOn1.setText("On");
        BtnOn1.setEnabled(true);
        BtnOff1.setText("Off");
        BtnOff1.setEnabled(true);
        TxtIp1.setVisibility(View.VISIBLE);
    }

    private void timer2(String Input) {
        TxtIp2.setVisibility(View.GONE);
        TimeDisplay2.setVisibility(View.VISIBLE);
        long miliInput = Long.parseLong(Input) * 60000;
        countDownTimer2 = new CountDownTimer(miliInput, 1000) {
            @Override
            public void onTick(long l) {updateTimer2((int) l/1000);}
            @Override
            public void onFinish() {
                if (bDevice1){
                    clickOn2();
                }else {
                    clickOff2();
                }
                ResetTimer2();
            }
        }.start();
    }
    public void updateTimer2(int secondsleft){
        int hours = secondsleft / 3600;
        int minutes = (secondsleft - hours * 3600) / 60;
        int seconds = secondsleft - (hours * 3600) - (minutes *60);
        TimeDisplay2.setText(hours + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }
    public void ResetTimer2(){
        TimeDisplay2.setVisibility(View.GONE);
        timeisActive2 = false;
        countDownTimer2.cancel();
        BtnOn2.setText("On");
        BtnOn2.setEnabled(true);
        BtnOff2.setText("Off");
        BtnOff2.setEnabled(true);
        TxtIp2.setVisibility(View.VISIBLE);
    }

    private void timer3(String Input) {
        TxtIp3.setVisibility(View.GONE);
        TimeDisplay3.setVisibility(View.VISIBLE);
        long miliInput = Long.parseLong(Input) * 60000;
        countDownTimer3 = new CountDownTimer(miliInput, 1000) {
            @Override
            public void onTick(long l) {updateTimer3((int) l/1000);}
            @Override
            public void onFinish() {
                if (bDevice3){
                    clickOn3();
                }else {
                    clickOff3();
                }
                ResetTimer3();
            }
        }.start();
    }
    public void updateTimer3(int secondsleft){
        int hours = secondsleft / 3600;
        int minutes = (secondsleft - hours * 3600) / 60;
        int seconds = secondsleft - (hours * 3600) - (minutes *60);
        TimeDisplay3.setText(hours + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }
    public void ResetTimer3(){
        TimeDisplay3.setVisibility(View.GONE);
        timeisActive3 = false;
        countDownTimer3.cancel();
        BtnOn3.setText("On");
        BtnOn3.setEnabled(true);
        BtnOff3.setText("Off");
        BtnOff3.setEnabled(true);
        TxtIp3.setVisibility(View.VISIBLE);
    }

    private void timer4(String Input) {
        TxtIp4.setVisibility(View.GONE);
        TimeDisplay4.setVisibility(View.VISIBLE);
        long miliInput = Long.parseLong(Input) * 60000;
        countDownTimer4 = new CountDownTimer(miliInput, 1000) {
            @Override
            public void onTick(long l) {updateTimer4((int) l/1000);}
            @Override
            public void onFinish() {
                if (bDevice4){
                    clickOn4();
                }else {
                    clickOff4();
                }
                ResetTimer4();
            }
        }.start();
    }
    public void updateTimer4(int secondsleft){
        int hours = secondsleft / 3600;
        int minutes = (secondsleft - hours * 3600) / 60;
        int seconds = secondsleft - (hours * 3600) - (minutes *60);
        TimeDisplay4.setText(hours + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }
    public void ResetTimer4(){
        TimeDisplay4.setVisibility(View.GONE);
        timeisActive4 = false;
        countDownTimer4.cancel();
        BtnOn4.setText("On");
        BtnOn4.setEnabled(true);
        BtnOff4.setText("Off");
        BtnOff4.setEnabled(true);
        TxtIp4.setVisibility(View.VISIBLE);
    }
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Timer-------------------------------------

    public void backmenu(View view) {
        Intent intent = new Intent(Room1Activity.this, MainActivity.class);
        startActivity(intent);
    }

}
