package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sk1,sk2,sk3;
    ImageButton ibtnplay;
    int soDiem=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sk1.setEnabled(false);
        sk2.setEnabled(false);
        sk3.setEnabled(false);
        txtDiem.setText(soDiem + "");
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int number = 5;
                Random random =new Random();
                int one=random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if (sk1.getProgress()>=sk1.getMax()){
                    this.cancel();
                    Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();
                    ibtnplay.setVisibility(View.VISIBLE);
                    if(cb1.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();
                }
                if(sk2.getProgress()>=sk2.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();
                    if(cb2.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();
                }
                if(sk3.getProgress()>=sk3.getMax()){
                    this.cancel();
                    ibtnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();
                    if(cb3.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "Bạn đoán chính xác", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=5;
                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem +"");
                    EnableCheckBox();
                }
                sk1.setProgress(sk1.getProgress()+one);
                sk2.setProgress(sk2.getProgress()+two);
                sk3.setProgress(sk3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()){
                    sk1.setProgress(0);
                    sk2.setProgress(0);
                    sk3.setProgress(0);
                    ibtnplay.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void Anhxa(){
        txtDiem = (TextView) findViewById(R.id.textviewDiem);
        ibtnplay = (ImageButton) findViewById(R.id.buttonPlay);
        cb1=(CheckBox) findViewById(R.id.checkbox1);
        cb2=(CheckBox) findViewById(R.id.checkbox2);
        cb3=(CheckBox) findViewById(R.id.checkbox3);
        sk1=(SeekBar) findViewById(R.id.seekbar1);
        sk2=(SeekBar) findViewById(R.id.seekbar2);
        sk3=(SeekBar) findViewById(R.id.seekbar3);
    }
}