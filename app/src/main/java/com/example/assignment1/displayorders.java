package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class displayorders<d> extends AppCompatActivity {

    TextView display;
    String order_list;
    private DataOutputStream read;
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayorders);

        Intent intent=getIntent();
        onLoad();


        SharedPreferences file=getSharedPreferences("order_list", Context.MODE_PRIVATE);
        order_list=file.getString("order","");
        display=(TextView) findViewById(R.id.order_screen);
        display.append(order_list);
        SharedPreferences.Editor info= file.edit();
        info.clear();
        info.commit();


    }

        public void onLoad(){
            Context context = getApplicationContext();
            Product product = (Product) FileEditor.readObjectFromFile(getApplicationContext());

            TextView textView = (TextView) findViewById(R.id.order_screen);
            String str = product.getName() + "\n" + product.getVolume() + " " + product.getIcing();
            textView.setText(str);
        }







}
/*
    public void outfile() throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("orders.txt");
        } catch (FileNotFoundException e) {
            Toast toast = Toast.makeText(getApplicationContext(), "File not found ...", Toast.LENGTH_LONG);
            toast.show();
        }
        display=(TextView) findViewById(R.id.order_screen);
        order_list=display.getText().toString();
        DataOutputStream fout = new DataOutputStream(new BufferedOutputStream(fos));
        try {
            fout.writeUTF(order_list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fout.close();
    }

    public void infile() throws IOException {
        FileInputStream fin = null;

        fin = new FileInputStream("orders.txt");
        DataInputStream read = new DataInputStream(fin);
        order_list=read.readUTF();
        display=(TextView) findViewById(R.id.order_screen);
        display.append(order_list);
         
           
        
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            outfile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

