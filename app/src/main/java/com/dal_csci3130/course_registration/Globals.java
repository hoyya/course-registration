package com.dal_csci3130.course_registration;


import java.io.Serializable;
import java.util.ArrayList;

public class Globals implements Serializable {

    //Instance variables
    private User user;
    private ArrayList<Course> courselist;

    public Globals() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourselist(ArrayList<Course> courselist) {
        this.courselist = courselist;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Course> getCourses() {
        return courselist;
    }
}
