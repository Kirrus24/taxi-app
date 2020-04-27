package com.example.laba2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button forward;
    private EditText name;
    private EditText lastName;
    private EditText tel;

    private static final String SAVED_TEXT1 = "Save1";
    private static final String SAVED_TEXT2 = "Save2";
    private static final String SAVED_TEXT3 = "Save3";
    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forward = (Button) findViewById((R.id.btnActTwo));
        name = (EditText) findViewById(R.id.name);
        lastName = (EditText) findViewById(R.id.lastname);
        tel = (EditText) findViewById(R.id.tel);

        loadText();

        if (name.getText().length() > 0 && lastName.getText().length() > 0 && tel.getText().length() > 0) {
            forward.setText("Войти");
        }
    }

    public void goNewView(View view){
        switch (view.getId()){
            case R.id.btnActTwo:
                Intent intent = new Intent(this, NewActivity.class);

                intent.putExtra("name", name.getText().toString());
                intent.putExtra("lastname", lastName.getText().toString());
                intent.putExtra("tel", tel.getText().toString());

                sPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sPref.edit();
                editor.putString(SAVED_TEXT1, name.getText().toString());
                editor.putString(SAVED_TEXT2, lastName.getText().toString());
                editor.putString(SAVED_TEXT3, tel.getText().toString());
                editor.commit();
                Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
                startActivity(intent);

                break;
                default:break;
        }
    }
    public void loadText(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText1 = sPref.getString(SAVED_TEXT1, "");
        String savedText2 = sPref.getString(SAVED_TEXT2, "");
        String savedText3 = sPref.getString(SAVED_TEXT3, "");
        name.setText(savedText1);
        lastName.setText(savedText2);
        tel.setText(savedText3);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
