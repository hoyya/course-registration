package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class compltedCourses extends AppCompatActivity {

    private Course course;
    private User user;
    private DataBase db;
    public ArrayAdapter<Course> results_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complted_courses);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");

        ArrayList<Course> courseList = user.getCompleted();

        //drop_Button = this.findViewById(R.id.dropButton);
        //Gets filter conditions
        ListView results_List = this.findViewById(R.id.resultsList);
        results_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courseList);
        results_List.setAdapter(results_Adapter);

        results_List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                course = user.getCompleted().get(position);
                Intent intent = new Intent(compltedCourses.this, rateCourse.class);
                Bundle extras = new Bundle();
                extras.putSerializable("user", user);
                extras.putSerializable("course", course);
                extras.putSerializable("database", db);
                intent.putExtras(extras);
                startActivityForResult(intent, 0);
            }
        });


    }


    //TODO: need to add a button to rate a course

    /**
     * return user and db to previous activity
     */
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

    /**
     *  Wait for results from initiated activity and update this activities params
     * @param requestCode = request code of activity
     * @param resultCode = result code of activity (expect 0)
     * @param data = bundles
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras = data.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
    }
}


