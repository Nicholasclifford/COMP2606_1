package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton donutbutton;
    ImageButton spongecake;
    ImageButton chocolate_cake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton donutbutton=(ImageButton) findViewById(R.id.imageButton3);
        ImageButton spongecake=(ImageButton) findViewById(R.id.imageButton2);
        ImageButton chocolate_cake=(ImageButton) findViewById(R.id.imageButton);

        donutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,donut.class);
                startActivity(intent2);
            }

        });

        spongecake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent3=new Intent(MainActivity.this,spongecake.class);
                startActivity(intent3);
            }});

        chocolate_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(MainActivity.this,chocolatecake.class);
                startActivity(intent4);
            }
        });

    }

    public void DisplayOrders(View view)
    {
        Intent intent=new Intent(this,displayorders.class);
        startActivity(intent);

    }


}