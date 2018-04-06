package com.dal_csci3130.course_registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class CourseDetails extends AppCompatActivity {

    private TextView notice;
    private Course course;
    private User user;
    private ArrayList<Course> completed, current, remaining;
    private DataBase db;
    private int rating;
    private TextView tview;
    private int max;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras != null) {
            user = (User) extras.getSerializable("user");
        }
        if (extras != null) {
            course = (Course) extras.getSerializable("course");
        }
        if (extras != null) {
            db = (DataBase) extras.getSerializable("database");
        }
        completed = user.getCompleted();
        current = user.getCurrent();
        remaining = user.getRemaining();
        rating = 0;
        if (course.getRating() != null) {
            System.out.println("rating size : " + course.getRating().size());
            for (int x = 0; x < course.getRating().size(); x++) {
                System.out.println("rating : " + course.getRating().get(x));
                rating += course.getRating().get(x);
                max += 1;
            }
        }
        notice = findViewById(R.id.notice);
        tview = findViewById(R.id.textView);
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

    @SuppressLint("SetTextI18n")
    public void addClass(View view) {
        boolean problem = false;

        for (int x = 0; x < completed.size(); x++) {
            if (course.getFaculty().equals(completed.get(x).getFaculty())) {
                if (course.getYear().equals(completed.get(x).getYear())) {
                    System.out.println("Already Completed");
                    notice.setText("Already Completed\n");
                    problem = true;
                }
            } else {
                notice.setText("");
            }
        }
        //check if course registered already
        for (int x = 0; x < current.size(); x++) {
            if (Objects.equals(course.getFaculty(), current.get(x).getFaculty()) && !problem) {
                if (Objects.equals(course.getYear(), current.get(x).getYear())) {
                    System.out.println("Already signed up\n");
                    notice.setText(notice.getText() + "Already Registered\n");
                    problem = true;
                }
            }
        }
        //check if course full
        if (Integer.parseInt(course.getRem()) < 1 && !problem) {
            System.out.println("course full");
            notice.setText(notice.getText() + "Course is full");
            problem = true;
        }
        //check time conflict
        if (!problem) {
            for (int x = 1; x < current.size(); x++) {
                if (Objects.equals(current.get(x).getTime(), course.getTime())) {
                    if (Objects.equals(current.get(x).getDays(), course.getDays())) {
                        //todo: check conflict conditions for edge cases
                        System.out.println("Time conflict between two classes\n");
                        notice.setText(notice.getText() + "Time conflict between two courses");
                        problem = true;
                    }
                }
            }
        }
        //if problem
        if (!problem) {
            System.out.println("rem_before: " + course.getRem());
            course.setRem("" + (Integer.parseInt(course.getRem()) - 1));
            System.out.println("rem_after: " + course.getRem());

            notice.setText("Course Successfully Added!");
            current.add(course);
            remaining.remove(course);
            user.setCurrent(current);
            user.setRemaining(remaining);
            db.updateCourse(course);
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
    }
    /**
     * return user and db to previous activity
     */

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

    //Getter and setter methods
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
