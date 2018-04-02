package com.dal_csci3130.course_registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class course_details extends AppCompatActivity {


    private TextView tview;
    private TextView notice;
    private Course course;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        user = (User) extras.getSerializable("user");
        course = (Course) extras.getSerializable("course");

        notice = (TextView) findViewById(R.id.notice);
        tview = (TextView) findViewById(R.id.textView);
        tview.setText(course.getTitle()+course.getYear()+"\nRemaining:"+course.getRem()+"\nCapacity:"+course.getCap()+"\nProffessor:"+course.getProfessor()+"\nBuilding:"+course.getLocation()+"\nDescription\n"+course.getDescription());



    }

    @SuppressLint("SetTextI18n")
    public void addClass(View view) {

        for (int x=0; x<user.getCurrent().size(); x++) {
            System.out.println("current before = "+user.getCurrent().get(x));
        }
        for (int x=0; x<user.getRemaining().size(); x++) {
            System.out.println("remaining before = "+user.getRemaining().get(x));
        }



        ArrayList<Course> completed = user.getCompleted();
        ArrayList<Course> current = user.getCurrent();
        ArrayList<Course> remaining = user.getRemaining();

        if (completed.contains(course) || current.contains(course)) {
            System.out.println("Already completed or signed up");
            notice.setText("Already Completed or Signed up to Course");
        }
        else {
            notice.setText("");
            current.add(course);
            remaining.remove(course);
            user.setCurrent(current);
            user.setRemaining(remaining);

            for (int x = 0; x < user.getCurrent().size(); x++) {
                System.out.println("current after = " + user.getCurrent().get(x));
            }
            for (int x = 0; x < user.getRemaining().size(); x++) {
                System.out.println("remaining after = " + user.getRemaining().get(x));
            }
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(0, intent);
        finish();
    }
}
