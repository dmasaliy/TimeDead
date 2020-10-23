package com.time.timedead;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

@SuppressLint("SetTextI18n")
public class Dead extends AppCompatActivity {

    TextView user;
    TextView date;
    String student;

    static private String lastDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dead);

        user = findViewById(R.id.username);
        date = findViewById(R.id.date);

        student = Objects.requireNonNull(getIntent().getExtras()).getString("username");


        date.setText(lastDate + " Year");
        user.setText(student);
    }

    static  void Dead(int kk){
        lastDate  = String.valueOf(kk);
    }
}