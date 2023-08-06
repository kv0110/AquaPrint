package com.example.aquaprint;

import static java.lang.Double.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class sinkScreen extends AppCompatActivity {
    EditText minutes;
    TextView name;
    Button next;
    String user;
    double minute, gallons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sink_screen);
        minutes = (EditText) findViewById(R.id.min);
        name = (TextView) findViewById(R.id.nm2);

        Bundle bundle = getIntent().getExtras();
        gallons = bundle.getDouble("gallons");
        user = bundle.getString("username");
        name.setText(user);

        next = (Button) findViewById(R.id.nextSlide);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minute = Double.parseDouble(minutes.getText().toString());
                gallons += minute*3*7;
                Intent toToil = new Intent(sinkScreen.this, toiletFlush.class);
                toToil.putExtra("username", user);
                toToil.putExtra("gallons", gallons);
                startActivity(toToil);
            }
        });
    }
}