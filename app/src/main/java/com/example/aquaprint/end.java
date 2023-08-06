package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class end extends AppCompatActivity {
    TextView name, gal, comp;
    String user;
    double gallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        name = (TextView) findViewById(R.id.nm6);
        gal = (TextView) findViewById(R.id.num);
        comp = (TextView) findViewById(R.id.compare);

        Bundle bundle = getIntent().getExtras();
        gallons = bundle.getDouble("gallons");
        user = bundle.getString("username");
        name.setText(user);

        gallons = (double)((int)(gallons * 100)) / 100;
        gal.setText("" + gallons);

        int average = 630;
        if (gallons == average) {
            comp.setText("Exactly the US average.");
        }
        else if (gallons > average) {
            comp.setText("" + (gallons - average) + " gallons more than US average.");
        }
        else {
            comp.setText("" + (average - gallons) + " gallons less than US average.");
        }
    }
}