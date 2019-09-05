package com.example.student.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import Database.DBhelper;
import Model.Users;

public class SelectData extends AppCompatActivity {

    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_data);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView );
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = new DBhelper(this);
        ArrayList<Users> us = db.readAllInfor();
        UserAdapter adapter = new UserAdapter(us);
        Log.i("DB" , us.get(0).getUname()  );
        recyclerView.setAdapter(adapter);
    }
}
