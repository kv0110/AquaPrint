package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText username;
    Button next;
    String uName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.name);
        next = (Button) findViewById(R.id.enter);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uName = username.getText().toString();
                Intent second = new Intent(MainActivity.this, explanation.class);
                second.putExtra("username", uName);
                startActivity(second);
            }
        });
    }
}