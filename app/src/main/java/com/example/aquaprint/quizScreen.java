package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class quizScreen extends AppCompatActivity {
    String user;
    TextView testing;
    Button bath, show;
    double gallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_screen);
        gallons = 35;
        testing = (TextView) findViewById(R.id.nm);
        user = getIntent().getStringExtra("username");
        testing.setText(user);
        bath = (Button) findViewById(R.id.bathtub);
        bath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSink = new Intent(quizScreen.this, sinkScreen.class);
                toSink.putExtra("username", user);
                toSink.putExtra("gallons", gallons);
                startActivity(toSink);
            }
        });

        show = (Button) findViewById(R.id.shower);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showTime = new Intent(quizScreen.this, showerTime.class);
                showTime.putExtra("username", user);
                startActivity(showTime);
            }
        });
    }
}