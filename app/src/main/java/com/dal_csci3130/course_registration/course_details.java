package com.dal_csci3130.course_registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class course_details extends AppCompatActivity {


    private TextView tview;
    private TextView notice;
    private Course course;
    private User user;
    private ArrayList<Course> completed;
    private ArrayList<Course> current;
    private ArrayList<Course> remaining;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        user = (User) extras.getSerializable("user");
        course = (Course) extras.getSerializable("course");

        completed = user.getCompleted();
        current = user.getCurrent();
        remaining = user.getRemaining();

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
                "\nDescription:\n"+course.getDescription()+
                "\n\nPrereq: "+course.getPrereq());

    }

    @SuppressLint("SetTextI18n")
    public void addClass(View view) {

        boolean problem = false;
        boolean timeconflict = false;
        Course conflict1;
        Course conflict2;

        //check if course completed
        System.out.println("Completed size = "+completed.size());

        for (int x=0; x<completed.size();x++) {
            System.out.println("in comp loop 1");
            boolean tmp = course.getFaculty().equals(completed.get(x).getFaculty());
            System.out.println(course.getFaculty()+" == "+completed.get(x).getFaculty()+" : "+tmp);

            if (course.getFaculty().equals(completed.get(x).getFaculty())) {
                System.out.println("in comp loop 2");
                System.out.println(course.getYear()+" == "+completed.get(x).getYear()+" : "+course.getYear() == completed.get(x).getYear());

                if (course.getYear().equals(completed.get(x).getYear())) {
                    System.out.println("course completed");
                    notice.setText("Already Completed\n");
                    problem = true;
                }
            }
            else {
                notice.setText("");
            }
        }


        System.out.println("Current size = "+current.size());

        //check if course registered already
        for (int x = 0; x< current.size(); x++) {

            System.out.println("in reg loop 1");
            System.out.println(course.getFaculty()+" == "+current.get(x).getFaculty()+" : "+course.getFaculty() == current.get(x).getFaculty());

            if (Objects.equals(course.getFaculty(), current.get(x).getFaculty()) && !problem) {

                System.out.println("in reg loop 2");
                System.out.println(course.getYear()+" == "+current.get(x).getYear()+" : "+course.getYear() == current.get(x).getYear());

                if (Objects.equals(course.getYear(), current.get(x).getYear())) {
                    System.out.println("Already signed up\n");
                    notice.setText(notice.getText()+"Already Registered\n");
                    problem = true;
                }
            }
        }

        //check if course full
        if (Integer.parseInt(course.getRem()) < 1 && !problem) {
            System.out.println("course full");
            notice.setText(notice.getText()+"Course is full");
            problem = true;
        }

        //check time conflict
        if (!problem) {
            for (int x=1; x<current.size();x++) {
                if (current.get(x).getTime() == course.getTime()) {
                    if (current.get(x).getDays() == course.getDays()) {
                        //todo: check conflict conditions for edge cases
                        System.out.println("Time conflict between two classes\n");
                        notice.setText(notice.getText()+"Time conflict between two courses");
                        problem = true;

                    }
                }
            }
        }

        //if problem
        if (problem == false) {
            course.setRem(""+(Integer.parseInt(course.getRem())-1));
            notice.setText("");
            current.add(course);
            remaining.remove(course);
            user.setCurrent(current);
            user.setRemaining(remaining);
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
