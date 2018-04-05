package com.dal_csci3130.course_registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
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
    private String notice;
    private boolean rated;
    private TextView tview;
    int max;

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
        rated = false;

        Spinner spinner = findViewById(R.id.rate_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rate_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        max = 0;
        if (course.getRating() != null) {
            System.out.println("rating size : " + course.getRating().size());
            for (int x = 0; x < course.getRating().size(); x++) {
                System.out.println("rating : " + course.getRating().get(x));
                rating += course.getRating().get(x);
                max += 1;
            }
        }

        tview = (TextView) findViewById(R.id.textView);
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

        //Adapter of rate
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("rating before = "+rating);
                switch (i) {
                    case 0:
                        rating = 1;
                        break;
                    case 1:
                        rating = 2;
                        break;
                    case 2:
                        rating = 3;
                        break;
                    case 3:
                        rating = 4;
                        break;
                    case 4:
                        rating = 5;
                        break;
                    case 5:
                        rating = 6;
                        break;
                    case 6:
                        rating = 7;
                        break;
                    case 7:
                        rating = 8;
                        break;
                    case 8:
                        rating = 9;
                        break;
                    case 9:
                        rating = 10;
                        break;
                }
                System.out.println("rating after = "+rating);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                rating = 1;
            }
        });
    }

    /**
     * Add a rating specified by the user to the course
     * @param view
     */
    @SuppressLint("SetTextI18n")
    public void addRating(View view) {
        if (!rated) {
            System.out.println("rating = " + rating);
            ArrayList<Integer> ratings = course.getRating();
            if (ratings == null) {
                ratings = new ArrayList<Integer>();
            }
            ratings.add(rating);
            course.setRating(ratings);
            db.updateCourse(course);
            max+=1;
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
        else {
            notice = "already rated this class";
        }
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
