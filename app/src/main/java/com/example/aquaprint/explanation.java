package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class explanation extends AppCompatActivity {
    Button takeQuiz;
    TextView testing;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);
        testing = (TextView) findViewById(R.id.test);
        user = getIntent().getStringExtra("username");
        testing.setText(user);
        takeQuiz = (Button) findViewById(R.id.quiz);
        takeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toQuiz = new Intent(explanation.this, quizScreen.class);
                toQuiz.putExtra("username", user);
                startActivity(toQuiz);
            }
        });
    }
}