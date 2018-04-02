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

    @SuppressLint("SetTextI18n")
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
        tview.setText(course.getTitle()+course.getYear()+
                "\nRemaining:"+course.getRem()+
                "\nCapacity:"+course.getCap()+
                "\nDays:"+course.getDays()+
                "\nTime:"+course.getTime()+
                "\nTerm:"+course.getTerm()+
                "\nProffessor:"+course.getProfessor()+
                "\nBuilding:"+course.getLocation()+
                "\nDescription\n"+course.getDescription());



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

        boolean problem = false;
        boolean timeconflict = false;
        Course conflict1;
        Course conflict2;

        for (int x=1; x<current.size();x++) {
            if (current.get(x).getTime() == course.getTime()) {
                if (current.get(x).getDays() == course.getDays()) {
                    //todo: check conflict conditions for edge cases
                    timeconflict = true;
                }
            }
        }

        if (completed.contains(course) || current.contains(course)) {
            System.out.println("Already completed or signed up\n");
            notice.setText("Already Completed or Signed up to Course\n");
            problem = true;
        }
        else {
            notice.setText("");
        }
        if (timeconflict) {
            System.out.println("Time conflict between two classes\n");
            notice.setText(notice.getText()+"Time conflict between two courses");
            problem = true;
        }
        if (!problem) {
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
