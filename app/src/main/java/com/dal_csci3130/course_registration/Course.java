package com.dal_csci3130.course_registration;


import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course implements Serializable {

    //Instance variables
    private String WL_Act, WL_Cap, WL_Rem, act, cap, cred, days, description, enddate, faculty, location, prereq, professor, rem, section, startdate, subject, term, time, title, year, prereqf;
    private ArrayList<Integer> rating;

    public Course() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * Constructor to easily set values for course object.
     *
     * @param WL_Act = People on wait list
     * @param WL_Cap = Max of wait list
     * @param WL_Rem = remaining on wait list
     * @param act = number of people in course
     * @param cap = max number of people in course
     * @param cred = How many credits the course is worth
     * @param days = What days of the week the ourse is held
     * @param description = a brief description of the course
     * @param enddate = Date the course ends
     * @param faculty = Comp Sci, Science, Arts, etc.
     * @param location = place where the class is held
     * @param prereq = If it is a prereq
     * @param professor = the prof
     * @param rem = remaining
     * @param section = class section
     * @param startdate = course start date
     * @param subject = What the course is about
     * @param term = Fall or Winter
     * @param time = the time of day of the class
     * @param title = What the course is officially called
     * @param year = the year the course is being held
     * @param prereqf = If it requires a prereq
     * @rating rating = what rating students give the course
     */
    public Course(String WL_Act, String WL_Cap, String WL_Rem, String act,
                  String cap, String cred, String days, String description, String enddate,
                  String faculty, String location, String prereq, String professor,
                  String rem, String section, String startdate, String subject, String term,
                  String time, String title, String year, String prereqf, ArrayList<Integer> rating) {
        this.WL_Act = WL_Act;
        this.WL_Cap = WL_Cap;
        this.WL_Rem = WL_Rem;
        this.act = act;
        this.cap = cap;
        this.cred = cred;
        this.days = days;
        this.description = description;
        this.enddate = enddate;
        this.faculty = faculty;
        this.location = location;
        this.prereq = prereq;
        this.professor = professor;
        this.rem = rem;
        this.section = section;
        this.startdate = startdate;
        this.subject = subject;
        this.term = term;
        this.time = time;
        this.title = title;
        this.year = year;
        this.prereqf = prereqf;
        this.rating = rating;
    }


    /**
     * This method is used to display all variables course object holds.
     *
     * @return
     */
    boolean stringify() {

        System.out.println(this.subject + "\n" + this.title + "\n" + this.year + "\n" + this.time + "\n" + this.term + "\n" + this.startdate + "\n" + this.section + "\n" + this.rem + "\n" + this.professor + "\n" + this.prereq + "\n" + this.location + "\n" + this.faculty + "\n" + this.enddate + "\n" + this.description + "\n" + this.days + "\n" + this.cred + "\n" + this.cap + "\n" + this.act + "\n" + this.WL_Rem + "\n" + this.WL_Act + "\n" + this.WL_Cap);

        return true;
    }

    //Returns if existence
    boolean exists() {
        return true;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("WL_Act", WL_Act);
        result.put("WL_Cap", WL_Cap);
        result.put("WL_Rem", WL_Rem);
        result.put("act", act);
        result.put("cap", cap);
        result.put("cred", cred);
        result.put("days", days);
        result.put("description", description);
        result.put("enddate", enddate);
        result.put("faculty", faculty);
        result.put("location", location);
        result.put("prereq", prereq);
        result.put("professor", professor);
        result.put("rem", rem);
        result.put("section", section);
        result.put("startdate", startdate);
        result.put("subject", subject);
        result.put("term", term);
        result.put("time", time);
        result.put("title", title);
        result.put("year", year);
        result.put("prereqf", prereqf);
        result.put("rating", rating);

        return result;
    }

    //Getter methods
    String getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    String getTerm() {
        return term;
    }

    public String getSubject() {
        return subject;
    }

    public String getStartdate() {
        return startdate;
    }

    String getSection() {
        return section;
    }

    String getRem() {
        return rem;
    }

    String getProfessor() {
        return professor;
    }

    String getPrereq() {
        return prereq;
    }

    String getPrereqf() {
        return prereqf;
    }

    String getLocation() {
        return location;
    }

    String getFaculty() {
        return faculty;
    }

    public String getEnddate() {
        return enddate;
    }

    String getDescription() {
        return description;
    }

    String getDays() {
        return days;
    }

    public String getCred() {
        return cred;
    }

    String getCap() {
        return cap;
    }

    public String getAct() {
        return act;
    }

    public String getWL_Rem() {
        return this.WL_Rem;
    }

    public String getWL_Cap() {
        return this.WL_Cap;
    }

    public String getWL_Act() {
        return this.WL_Act;
    }

    ArrayList<Integer> getRating() {
        return this.rating;
    }

    public void setWL_Cap(String WL_Cap) {
        this.WL_Cap = WL_Cap;
    }

    //Setter methods
    public void setWL_Act(String WL_Act) {
        this.WL_Act = WL_Act;
    }

    public void setWL_Rem(String WL_Rem) {
        this.WL_Rem = WL_Rem;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRating(ArrayList<Integer> rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setTime(String time) {

        this.time = time;
    }

    public void setTerm(String term) {

        this.term = term;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }

    public void setStartdate(String startdate) {

        this.startdate = startdate;
    }

    public void setSection(String section) {

        this.section = section;
    }

    public void setRem(String rem) {

        this.rem = rem;
    }

    public void setProfessor(String professor) {

        this.professor = professor;
    }

    public void setPrereq(String prereq) {

        this.prereq = prereq;
    }

    public void setPrereqf(String prereqf) {
        this.prereqf = prereqf;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFaculty(String faculty) {

        this.faculty = faculty;
    }

    public void setEnddate(String enddate) {

        this.enddate = enddate;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setCred(String cred) {
        this.cred = cred;
    }

    public void setCap(String cap) {

        this.cap = cap;
    }


    public String toString() {
        return this.title + " " + this.faculty + this.year + " \n" + this.term + " " + this.days + " " + this.time;
    }
}