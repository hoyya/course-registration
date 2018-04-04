package com.dal_csci3130.course_registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class rateCourse extends AppCompatActivity {

    private Course course;
    private User user;
    private DataBase db;
    private int rating;
    private Spinner spinner;
    private Adapter adapter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_course);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        assert extras != null;
        user = (User) extras.getSerializable("user");
        course = (Course) extras.getSerializable("course");
        db = (DataBase) extras.getSerializable("database");
        rating = 0;

        //todo: add spinner
        Spinner spinner = findViewById(R.id.rate_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rate_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        int max = 0;
        if (course.getRating() != null) {
            System.out.println("rating size : " + course.getRating().size());
            for (int x = 0; x < course.getRating().size(); x++) {
                System.out.println("rating : " + course.getRating().get(x));
                rating += course.getRating().get(x);
                max += 1;
            }
        }

        TextView tview = (TextView) findViewById(R.id.textView);
        tview.setText(course.getTitle() + course.getYear() +
                "\nRemaining:" + course.getRem() +
                "\nCapacity:" + course.getCap() +
                "\nDays:" + course.getDays() +
                "\nTime:" + course.getTime() +
                "\nTerm:" + course.getTerm() +
                "\nProffessor:" + course.getProfessor() +
                "\nRating: " + (rating / 1.0) / max +
                "\nBuilding:" + course.getLocation() +
                "\nDescription:\n" + course.getDescription() +
                "\n\nPrereq of: " + course.getPrereq() +
                "\n\nPrereq for: " + course.getPrereqf());
    }

    /**
     * Add a rating specified by the user to the course
     * @param view
     */
    public void addRating(View view) {
        //todo: grab rating from spinner
        rating = 8;
        ArrayList<Integer> ratings = course.getRating();
        ratings.add(rating);
        course.setRating(ratings);
        db.updateCourse(course);
    }

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
