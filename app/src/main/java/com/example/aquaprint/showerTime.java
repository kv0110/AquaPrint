package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class showerTime extends AppCompatActivity {
    EditText minutes;
    TextView name;
    Button next;
    String user;
    double gallons, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower_time);
        minutes = (EditText) findViewById(R.id.min2);
        name = (TextView) findViewById(R.id.myName);

        user = getIntent().getStringExtra("username");
        name.setText(user);

        next = (Button) findViewById(R.id.nextSlide2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minute = Double.parseDouble(minutes.getText().toString());
                gallons = minute*2.5*7;
                Intent toSink = new Intent(showerTime.this, sinkScreen.class);
                toSink.putExtra("username", user);
                toSink.putExtra("gallons", gallons);
                startActivity(toSink);
            }
        });
    }
}