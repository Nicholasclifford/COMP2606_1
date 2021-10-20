package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;

public class Confirmorder extends AppCompatActivity {

    public ArrayList<String> order= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmorder);
        Intent intent = getIntent();

        order = intent.getStringArrayListExtra("list");
        TextView display = (TextView) findViewById(R.id.textView5);
        for (String s : order) {
            display.append(s);
            display.append("\n");
        }
    }


    public void confirmorder(View view) {
        TextView display = (TextView) findViewById(R.id.textView5);
        String s=display.getText().toString();
        Intent whatsapp=new Intent();
        whatsapp.setAction(Intent.ACTION_SEND);
        whatsapp.putExtra(Intent.EXTRA_TEXT,s);
        whatsapp.setType("text/plain");
        whatsapp.setPackage("com.whatsapp");
        startActivity(whatsapp);

    }
}