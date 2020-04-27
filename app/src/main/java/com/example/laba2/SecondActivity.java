package com.example.laba2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

     EditText street;
     EditText house;
     EditText section;
     EditText streetTwo;
     EditText houseTwo;
     EditText sectionTwo;
     Button forward;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);

        forward = (Button) findViewById((R.id.btnActTwo));
        street = (EditText) findViewById(R.id.streetName);
        house = (EditText) findViewById(R.id.houseName);
        section= (EditText) findViewById(R.id.sectionName);
        streetTwo = (EditText) findViewById(R.id.streetTwoName);
        houseTwo = (EditText) findViewById(R.id.houseTwoName);
        sectionTwo = (EditText) findViewById(R.id.sectionTwoName);
        forward.setOnClickListener(this);
    }
    public void onClick(View view){
        Intent intent = new Intent();
        intent.putExtra("name", street.getText().toString());
        intent.putExtra("nameHouse", house.getText().toString());
        intent.putExtra("nameSection", section.getText().toString());
        intent.putExtra("nameStreetTwo", streetTwo.getText().toString());
        intent.putExtra("nameHouseTwo", houseTwo.getText().toString());
        intent.putExtra("nameSectionTwo", sectionTwo.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
