package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class chocolatecake extends AppCompatActivity {

    ArrayList<String> mylist= new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolatecake);
        Intent intent=getIntent();
    }

//    public void onCheckboxClicked(View view)
//    {
//        CheckBox item =((CheckBox)view);
//        boolean v=item.isChecked();
//        String option=item.getText().toString();
//        if(v)
//        {
//            mylist.add(option);
//        }
//        else{
//            mylist.remove(option);
//        }
//
//    }

    public void onclickAddToCart(View view){
        CheckBox checkbox = (CheckBox) findViewById(R.id.icing);
        String checkboxText = "";
        String radioText;

        boolean checked = checkbox.isChecked();
        if(checked){
            checkboxText = checkbox.getText().toString();
        }
        //RadioButton radioButton = (RadioButton) findViewById(R.id)
        RadioGroup radioGroup = (RadioGroup) findViewById((R.id.radio_group));
        int id = radioGroup.getCheckedRadioButtonId();

        if (id == -1){
            Toast toast = Toast.makeText(getApplicationContext(), "Please select a type of cake", Toast.LENGTH_LONG);
            toast.show();

        }
        else{
            RadioButton type = findViewById(id);
           // String radio_text = radioButton.getText().toString();
           // product.setVolume(radio_text);

            Button b = (Button) findViewById(radioGroup.getCheckedRadioButtonId());
            mylist.add("\n" + "Chocolate cake");
            mylist.add(b.getText().toString());
            mylist.add(checkboxText);
            radioText = b.getText().toString();


            products.add(new Product("Chocolate Cake", radioText, checkboxText));

        }

    }

    public void onclickConfirmOrder(View view){



        for(Product product : products){
            FileEditor.writeToFile(getApplicationContext(), product);
        }

        Intent intent = new Intent(this, Confirmorder.class);
        intent.putStringArrayListExtra("list",mylist);
        startActivity(intent);

    }
}