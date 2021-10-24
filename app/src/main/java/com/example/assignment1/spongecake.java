package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class spongecake extends AppCompatActivity {

    RadioGroup type;
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<String> mylist=new ArrayList<String>();
    ArrayList<Product> spongecakeorder=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spongecake);

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

    public void onclickAddToCart(View view)
    {

        CheckBox checkbox = (CheckBox) findViewById(R.id.icing);
        String checkboxText = "";
        String radioText = "";
        boolean checked = checkbox.isChecked();
        if(checked){
            checkboxText = checkbox.getText().toString();
        }

        type=(RadioGroup) findViewById(R.id.radio_group);


        if(type.getCheckedRadioButtonId()==-1 )
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Please select a type of cake", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            //mylist.add(0,"Sponge cake");
            Button b = (Button) findViewById(type.getCheckedRadioButtonId());
            mylist.add("\n" + "Sponge cake");
            mylist.add(b.getText().toString());
            mylist.add(checkboxText);
            radioText = b.getText().toString();

            products.add(new Product("Sponge Cake", radioText, checkboxText));

        }

    }



    public void onclickConfirmOrder(View view) {

        for (Product product:products){
            FileEditor.writeToFile(getApplicationContext(), product);
        }


        Intent intent = new Intent(this, Confirmorder.class);
        intent.putStringArrayListExtra("list",mylist);
        startActivity(intent);


    }
}