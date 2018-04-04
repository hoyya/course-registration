package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

    //Instance variables
    private String email;
    private String first_name;
    private ArrayList<Course> completed;
    private ArrayList<Course> current;
    private ArrayList<Course> remaining;
    private String last_name;
    private String password;
    private String username;
    private String notices;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Constructor to easily set User object information upon instantiation.
     *
     * @param email
     * @param first_name
     * @param completed
     * @param current
     * @param remaining
     * @param last_name
     * @param password
     * @param username
     */
    public User(String email, String first_name, ArrayList<Course> completed, ArrayList<Course> current, ArrayList<Course> remaining,
                String last_name, String password, String username) {
        this.email = email;
        this.first_name = first_name;
        this.completed = completed;
        this.current = current;
        this.remaining = remaining;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
        this.notices = "";
    }

    //Getter and setter methods for variable
    public ArrayList<Course> getCompleted() {
        return completed;
    }

    public void setCompleted(ArrayList<Course> completed) {
        this.completed = completed;
    }

    public ArrayList<Course> getCurrent() {
        return current;
    }

    public void setCurrent(ArrayList<Course> current) {
        this.current = current;
    }

    public ArrayList<Course> getRemaining() {
        return remaining;
    }

    public void setRemaining(ArrayList<Course> remaining) {
        this.remaining = remaining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
    }

    boolean exists() {
        return true;
    }

    /**
     * Method to display User object information
     *
     * @return
     */
    boolean stringify() {

        System.out.println(this.email + "\n" + this.first_name + "\n" + "\n" + this.last_name + "\n" + this.password + "\n" + this.username);

        return true;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("e-mail", email);
        result.put("first_name", first_name);
        result.put("last_name", last_name);
        result.put("password", password);
        result.put("username", username);
        result.put("notices", notices);

        return result;
    }
}