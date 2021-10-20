package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class Confirmorder extends AppCompatActivity {

    public ArrayList<String> order= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);
        Intent intent=getIntent();

       order=intent.getStringArrayListExtra("list");
        TextView display=(TextView) findViewById(R.id.textView5);
        for(String s: order)
        {
           display.append(s);
           display.append("\n");
        }




    }
}