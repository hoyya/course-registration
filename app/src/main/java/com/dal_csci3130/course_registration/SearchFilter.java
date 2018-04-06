package com.dal_csci3130.course_registration;

import java.util.ArrayList;
import java.util.Objects;

public class SearchFilter {

    private String m_faculty;
    private int m_year, m_open_spots;
    ;
    private DataBase db;

    /*
     This method will make an API call to the database.
     We need an onclick action in the UI to trigger this method.
     Elementary error checking implemented, UI needs to catch a "NULL" return.
                        ------ UNFINISHED ----
     */

    public SearchFilter(DataBase in_db) {
        m_faculty = "";
        m_year = 0;
        m_open_spots = 0;
        db = in_db;
        System.out.println("Size of courselist in SearchFilter: " + db.getCourselist().size());

    }

    /* update a course:
        SearchFilter update = new SearchFilter();
        update.UPDATE_COURSE_DB(course);
     */
    public void UPDATE_COURSE_DB(Course course) {


        for (int i = 0; i < db.getCourselist().size(); i++) {
            if (db.getCourselist().get(i).getFaculty() == course.getFaculty() && db.getCourselist().get(i).getYear() == course.getYear()) {
                db.getCourselist().remove(i);
                db.getCourselist().add(course);
            }
        }
    }

    /* update a user:
        SearchFilter update = new SearchFilter();
        update.UPDATE_USER_DB(user);
     */
    public void UPDATE_USER_DB(User user) {

        for (int i = 0; i < db.getCourselist().size(); i++) {
            if (db.getUserlist().get(i).getUsername() == user.getUsername()) {
                db.getUserlist().remove(i);
                db.getUserlist().add(user);
            }
        }
    }

    /* query courses:
        SearchFilter update = new SearchFilter();
        ArrayList<Course> courselist = update.QUERY_COURSES_DB(term, faculty, year, open_spots);
     */
    public ArrayList<Course> QUERY_COURSES_DB(String m_faculty, String year, String term) {


        ArrayList<Course> results = new ArrayList<Course>();
        //String results = "";
        //String results = db.getCourselist().get(0).getFaculty()+db.getCourselist().get(0).getYear()+" "+db.getCourselist().get(0).getRem()+" seats remaining";

        for (int i = 0; i < db.getCourselist().size(); i++) {
            if (db.getCourselist().get(i).getFaculty() == m_faculty || m_faculty == "ANY") {
                if ((db.getCourselist().get(i).getYear().charAt(0) == year.charAt(0)) || (year == "ANY")) {
                    if (true) {
                        //if ((Integer.parseInt(m_open_spots) == Integer.parseInt(db.getCourselist().get(i).getRem())) || (m_open_spots == "0")) {
                        results.add(db.getCourselist().get(i));
                    }
                }
            }
        }
        return results;

    }

    /* query courses:
        SearchFilter update = new SearchFilter();
        ArrayList<Course> courselist = update.QUERY_COURSES_DB(faculty, year, open_spots);
    */
    public ArrayList<Course> QUERY_COURSES_DB(String m_faculty, String year) {


        ArrayList<Course> results = new ArrayList<Course>();
        System.out.println("Size of courselist while querying: " + db.getCourselist().size());
        for (int i = 0; i < db.getCourselist().size(); i++) {
            if (Objects.equals(db.getCourselist().get(i).getFaculty(), m_faculty) || Objects.equals(m_faculty, "ANY")) {
                if ((db.getCourselist().get(i).getYear().charAt(0) == year.charAt(0)) || (Objects.equals(year, "ANY"))) {
                    results.add(db.getCourselist().get(i));
                }
            }
        }
        return results;
    }

    /* query a user:
        SearchFilter update = new SearchFilter();
        User user = update.QUERY_USERS_DB(username, password);
     */
    public User QUERY_USERS_DB(String username, String password) {
        DataBase db = new DataBase();
        db.initialize();

        ArrayList<User> results = new ArrayList<User>();

        for (int i = 0; i < db.getUserlist().size(); i++) {
            if (db.getUserlist().get(i).getUsername() == username) {
                if (db.getUserlist().get(i).getPassword() == password) {
                    return db.getUserlist().get(i);
                }
            }
        }


        return null;
    }

    /*
    public DataBase query_course(DataBase db, ArrayList<String> query, ArrayList<String> variable) {
        DataBase results = new DataBase();
        for (int j = 0; j < query.size(); j++)
            for (int i = 0; i < db.getCourselist().size(); i++) {
                if (db.getCourselist().get(i).getFaculty() == query.get(j)) {
                    results.addCourse(db.getCourselist().get(i));
                }
            }
        }
        return results;
    }
    */

    /* GETTERS FOR FILTERED_SEARCH. */
    public String getm_faculty() {
        return this.m_faculty;
    }

    public int getm_year() {
        return this.m_year;
    }

    public int getm_open_spots() {
        return this.m_open_spots;
    }

    /* SETTERS FOR FILTERED_SEARCH */
    public void setm_faculty(String set_fac) {
        this.m_faculty = set_fac;
    }

    public void setm_year(int set_year) {
        this.m_year = set_year;
    }

    public void setm_open_spots(int set_open_spots) {
        this.m_open_spots = set_open_spots;
    }

}