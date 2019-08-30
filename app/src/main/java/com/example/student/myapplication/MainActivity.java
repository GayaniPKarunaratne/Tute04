package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBhelper;

public class MainActivity extends AppCompatActivity {

    EditText txt_username, txt_password;
    DBhelper db;
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_username = findViewById(R.id.UserName);
        txt_password = findViewById(R.id.Pwd);
        db = new DBhelper(this);

    }

    public void addInfro(View view){
        userName = txt_username.getText().toString();
        password = txt_password.getText().toString();

        boolean result = db.addUser(userName,password);

        if (result == true){
            Toast.makeText(getApplicationContext(),"User add to DB",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Erro in user adding",Toast.LENGTH_LONG).show();
        }
    }

}
