package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class chocolatecake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chocolatecake);
        Intent intent=getIntent();
    }

    public void onclickAddToCart(View view){
        Product product = new Product();
        CheckBox checkbox = (CheckBox) findViewById(R.id.icing);
        boolean checked = checkbox.isChecked();
        product.setIcing(checked);
        //RadioButton radioButton = (RadioButton) findViewById(R.id)
        RadioGroup radioGroup = (RadioGroup) findViewById((R.id.radio_group));
        int id = radioGroup.getCheckedRadioButtonId();

        if (id == -1){
            TextView textView = (TextView) findViewById(R.id.textView3);
            textView.setText("Please finish the form!");
        }
        else{
            RadioButton radioButton = findViewById(id);
            String radio_text = radioButton.getText().toString();
            product.setVolume(radio_text);
        }

    }
}