package com.dal_csci3130.course_registration;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {

    //Instance variables
    private String email, first_name, last_name, password, username, notices, major, minor;
    private ArrayList<Course> completed, current, remaining;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Constructor to easily set User object information upon instantiation.
     *
     * @param email = the email of the user
     * @param first_name = user's first name
     * @param completed = courses the user has completed
     * @param current = current courses being taken by the user
     * @param remaining = classes the user still has to take
     * @param last_name = user's last name
     * @param password = user's password
     * @param username = user's username
     */
    public User(String email, String first_name, ArrayList<Course> completed, ArrayList<Course> current, ArrayList<Course> remaining,
                String last_name, String password, String username, String major, String minor) {
        this.email = email;
        this.first_name = first_name;
        this.completed = completed;
        this.current = current;
        this.remaining = remaining;
        this.last_name = last_name;
        this.password = password;
        this.username = username;
        this.notices = "";
        this.major = major;
        this.minor = minor;
    }

    //Getter and setter methods for variable
    ArrayList<Course> getCompleted() {
        return completed;
    }

    void setCompleted(ArrayList<Course> completed) {
        this.completed = completed;
    }

    ArrayList<Course> getCurrent() {
        return current;
    }

    void setCurrent(ArrayList<Course> current) {
        this.current = current;
    }

    ArrayList<Course> getRemaining() {
        return remaining;
    }

    void setRemaining(ArrayList<Course> remaining) {
        this.remaining = remaining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    String getLast_name() {
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

    String getMajor() { return major; }

    void setMajor(String major) { this.major = major; }

    String getMinor() { return minor; }

    void setMinor(String minor) { this.minor = minor; }

    /**
     * Method to display User object information
     *
     * @return returns variable
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