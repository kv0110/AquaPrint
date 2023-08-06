package com.example.aquaprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class washing extends AppCompatActivity {
    TextView name;
    Button yes, no;
    String user;
    double gallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_washing);
        name = (TextView) findViewById(R.id.nm5);

        Bundle bundle = getIntent().getExtras();
        gallons = bundle.getDouble("gallons");
        user = bundle.getString("username");
        name.setText(user);

        yes = (Button) findViewById(R.id.yes2);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallons += 34;
                Intent toToil = new Intent(washing.this, end.class);
                toToil.putExtra("username", user);
                toToil.putExtra("gallons", gallons);
                startActivity(toToil);
            }
        });

        no = (Button) findViewById(R.id.no2);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gallons += 20;
                Intent toToil = new Intent(washing.this, end.class);
                toToil.putExtra("username", user);
                toToil.putExtra("gallons", gallons);
                startActivity(toToil);
            }
        });
    }
}