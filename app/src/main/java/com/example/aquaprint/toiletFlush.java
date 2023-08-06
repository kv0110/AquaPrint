package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class toiletFlush extends AppCompatActivity {
    EditText minutes;
    TextView name;
    Button next;
    String user;

    double gallons, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilet_flush);
        minutes = (EditText) findViewById(R.id.min3);
        name = (TextView) findViewById(R.id.nm3);

        Bundle bundle = getIntent().getExtras();
        gallons = bundle.getDouble("gallons");
        user = bundle.getString("username");
        name.setText(user);

        next = (Button) findViewById(R.id.nextSlide3);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minute = Double.parseDouble(minutes.getText().toString());
                gallons += minute*1.6*7;
                Intent dish = new Intent(toiletFlush.this, dishwasher.class);
                dish.putExtra("username", user);
                dish.putExtra("gallons", gallons);
                startActivity(dish);
            }
        });
    }
}