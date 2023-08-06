package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dishwasher extends AppCompatActivity {
    TextView name;
    Button yes, no;
    String user;
    double gallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishwasher);
        name = (TextView) findViewById(R.id.nm4);

        Bundle bundle = getIntent().getExtras();
        gallons = bundle.getDouble("gallons");
        user = bundle.getString("username");
        name.setText(user);

        yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallons += 9.5;
                Intent toToil = new Intent(dishwasher.this, washing.class);
                toToil.putExtra("username", user);
                toToil.putExtra("gallons", gallons);
                startActivity(toToil);
            }
        });

        no = (Button) findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallons += 20;
                Intent toToil = new Intent(dishwasher.this, washing.class);
                toToil.putExtra("username", user);
                toToil.putExtra("gallons", gallons);
                startActivity(toToil);
            }
        });
    }
}