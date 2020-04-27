package com.example.laba2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    Button forwardTwo;
    private TextView name;
    private TextView lastName;
    private TextView telTxt;
    TextView pathText;
    Button buttonConfirm;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two);

        forwardTwo = (Button) findViewById(R.id.path_button);
        pathText = (TextView) findViewById(R.id.pathText);
        name = (TextView) findViewById(R.id.nametxt);
        lastName = (TextView) findViewById(R.id.lastnametxt);
        telTxt = (TextView) findViewById(R.id.teltxt);
        forwardTwo.setOnClickListener(this);
        buttonConfirm = findViewById(R.id.button_confirm);

        String txtName = getIntent().getStringExtra("name");
        String txtLastName = getIntent().getStringExtra("lastname");
        String txtTel = getIntent().getStringExtra("tel");

        name.setText(name.getText().toString()+" "+ txtName);
        lastName.setText(lastName.getText().toString()+" "+ txtLastName);
        telTxt.setText(telTxt.getText().toString()+ " " + txtTel);

        pathText.addTextChangedListener(loginTextWatcher);

    }
    private TextWatcher loginTextWatcher = new TextWatcher(){
        @Override
        public  void beforeTextChanged(CharSequence s, int start, int count, int after){

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count){
            String usernameInput = pathText.getText().toString().trim();

            buttonConfirm.setEnabled(!usernameInput.isEmpty());
        }
        @Override
        public void afterTextChanged(Editable s){

        }
    };
    public void onClick(View view){
        Intent intent=new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 1);


    }
    public void showToast(View view){
        Toast toast = Toast.makeText(getApplicationContext(),"Такси уже в пути", Toast.LENGTH_LONG);
        toast.show();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data==null){
            return;
        }
        String name=data.getStringExtra("name");
        String nameHouse=data.getStringExtra("nameHouse");
        String nameSection=data.getStringExtra("nameSection");
        String nameStreetTwo=data.getStringExtra("nameStreetTwo");
        String nameHouseTwo=data.getStringExtra("nameHouseTwo");
        String nameSectionTwo=data.getStringExtra("nameSectionTwo");
        pathText.setText("Такси прибудет к " + name + " "+ nameHouse +", "+ nameSection +" через 5 минут и отправится к " + nameStreetTwo
                + " "+ nameHouseTwo +", "+ nameSectionTwo + " .Если вы согласны нажмите Подтвердить");
    }

}
