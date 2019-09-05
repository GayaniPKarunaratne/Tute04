package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Database.DBhelper;
import Model.Users;

public class MainActivity extends AppCompatActivity {

    EditText txt_username, txt_password;
    TextView data;
    DBhelper db;
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_username = findViewById(R.id.UserName);
        txt_password = findViewById(R.id.Pwd);
        data = findViewById(R.id.data);
        db = new DBhelper(this);

        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for ( Users user : u ) {
            data.append( count  + " " + user.getUname() + "\t\t" + user.getPassword() + "\n"  );
            count++;
        }


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
        displayInfo(view);

    }

    public void displayInfo(View view){
        data.setText("");
        int count = 1;

        ArrayList<Users> u = db.readAllInfor();
        for ( Users user : u ) {
            data.append( count  + " " + user.getUname() + "\t\t\t" + user.getPassword() + "\n"  );
            count++;
        }

    }

    public void deleteUser(View view){
        userName = txt_username.getText().toString();
        db.deleteuser( userName );
        displayInfo(view);


    }

    public void update( View view){
        userName = txt_username.getText().toString();
        password = txt_password.getText().toString();
        db.userUpdate( userName , password );
        displayInfo(view);
    }

}
