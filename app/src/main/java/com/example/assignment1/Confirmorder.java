package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;


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
        SharedPreferences order=getSharedPreferences("order_list",MODE_PRIVATE);
        String s=display.getText().toString();
        SharedPreferences.Editor edit= order.edit();
        edit.putString("order",s);
        edit.commit();



        Product_order new_order=new Product_order(s);

        FileEditor.writeToFile(getApplicationContext(), new_order);


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

    public void Home(View view) {
        Intent intent3=new Intent(this,MainActivity.class);
        startActivity(intent3);
    }
}