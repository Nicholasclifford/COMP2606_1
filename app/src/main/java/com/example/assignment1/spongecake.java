package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class spongecake extends AppCompatActivity {

    RadioGroup type;
    CheckBox icing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spongecake);

        Intent intent=getIntent();
    }



    public void onclickAddToCart(View view)
    {
        type=(RadioGroup) findViewById(R.id.radio_group);
        icing=(CheckBox) findViewById(R.id.icing);

        if(type.getCheckedRadioButtonId()==-1)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Please select a type of cake", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {

            Intent intent = new Intent(this, Confirmorder.class);

            startActivity(intent);
        }

    }
}