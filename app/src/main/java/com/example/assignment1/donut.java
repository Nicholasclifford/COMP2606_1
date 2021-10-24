package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class donut extends AppCompatActivity {

    public RadioGroup size;
    public RadioGroup type;
    public Switch filling;
    ArrayList<String> donut_size;
    HashSet<String> donut_type;
    ArrayList<String> order = new ArrayList<String>();
    ArrayList<Product> dountorder =new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        Intent intent = getIntent();


    }

/*    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList("list", order);
    }*/


    public void onRadioButtonClicked(View view) {
        RadioButton item = ((RadioButton) view);
        boolean checked = item.isChecked();
        String option = item.getText().toString();

        if (checked) {
            donut_size.add(option);
        } else {
            donut_size.remove(option);
        }

    }

    public void send_order(View view) {

        size=(RadioGroup) findViewById(R.id.donutamount);
        type=(RadioGroup) findViewById(R.id.donut_type);
        filling=(Switch) findViewById(R.id.switch1);




        if (size.getCheckedRadioButtonId() == -1 || type.getCheckedRadioButtonId() == -1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Both fields must be clicked", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
            {


                order.add("\n"+ "Donut");


            Button b = (Button) findViewById(size.getCheckedRadioButtonId());
            order.add(b.getText().toString());
            Button f = (Button) findViewById(type.getCheckedRadioButtonId());
            order.add(f.getText().toString());

                String radioText = b.getText().toString();
                String d=f.getText().toString();
            //Product products=new Product("donut",radioText,d);

            if(filling.isChecked())
            {
                order.add("Fill donuts with cream");
            }

                if (order.isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Nothing was selected...", Toast.LENGTH_LONG);
                    toast.show();
                }

                Toast toast = Toast.makeText(getApplicationContext(), "Item added", Toast.LENGTH_SHORT);
                toast.show();

        }
    }


    public void onclickConfirmOrder(View view) {

//        for(Product product : dountorder){
//            FileEditor.writeToFile(getApplicationContext(), product);
//        }

        Intent intent2 = new Intent(this, Confirmorder.class);
        intent2.putStringArrayListExtra("list", order);
        startActivity(intent2);

    }
}

