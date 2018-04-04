package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class currentClasses extends AppCompatActivity {

    private User user;
    private DataBase db;
    public ArrayAdapter<Course> results_Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_classes);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");

        ArrayList<Course> courseList = user.getCurrent();

        //drop_Button = this.findViewById(R.id.dropButton);
        //Gets filter conditions
        ListView results_List = this.findViewById(R.id.resultsList);
        results_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList);
        results_List.setAdapter(results_Adapter);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putSerializable("user", user);
        extras.putSerializable("database", db);
        intent.putExtras(extras);
        setResult(0, intent);
        finish();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
    }
}

