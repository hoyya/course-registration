package com.dal_csci3130.course_registration;


import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable {

	private ArrayList<Course> courselist;
	private ArrayList<User> userlist;

	public DataBase() {
		courselist = new ArrayList<Course>();
		userlist = new ArrayList<User>();
	}

	public DataBase(ArrayList<Course> courselist, ArrayList<User> userlist) {
		this.courselist = courselist;
		this.userlist = userlist;
	}


	public void initialize() {
		////GET ALL DB OBJECTS
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(7);
		l1.add(9);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(8);
		l2.add(9);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(5);
		l3.add(7);
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l4.add(5);
		l4.add(3);

		//Computer Science and Math Courses
		Course course1 = new Course("0","20","20","91","115","3.000","TR","Implementing Agile workstyle as a team","04/06/2018","CSCI","Psychology building","{CSCI2110 : C|CSCI2111 : C}","Juliano Franz","24","01","01/08/2018","CSCI","winter","14:35-15:55","Software Engineering","3130", "CSCI4116: C", l1);
		Course course2 = new Course("0","20","20","91","100","3.000","MWF","Introduction to Cryptography","04/06/2018","CSCI","LSC","{CSCI2110 : C|CSCI2111 : C}","Peter Selinger","9","01","01/08/2018","CSCI","winter","14:35-15:25","Cryptography","4116", "", l2);
		Course course3 = new Course("15","20","5","95","95","3.000","TR","Operating systems","04/06/2018","CSCI","Psychology building","{CSCI2110 : C|CSCI2111 : C}","Alex Brodsky","0","01","01/08/2018","CSCI","winter","13:05-14:30","Operating Systems","3120", "CSCI4116: C", l3);
		Course course4 = new Course("15","20","5","95","95","3.000","MTW","UI Design","12/12/2017","CSCI","LSC Building","{CSCI2110 : C|CSCI2111 : C}","Math Teacher","44","01","06/08/2017","CSCI","fall","8:30-9:55","UI Design","3160", "", l4);
		Course course5 = new Course("15","20","5","95","95","3.000","MTW","Matrices","12/12/2017","MATH","LSC Building","{MATH2110 : C|MATH2111 : C}","Math Teacher","5","01","06/08/2017","CSCI","fall","8:30-9:55","Matrices","2210", "", null);
		Course course6 = new Course("15","20","5","95","95","3.000","MTW","Equations","12/12/2017","MATH","LSC Building","{MATH2110 : C|MATH2111 : C}","Math Teacher","0","01","06/08/2017","CSCI","fall","8:30-9:55","Equations","2211", "", null);
		Course course7 = new Course("15","20","5","95","95","3.000","MTW","Graphs","12/12/2017","MATH","LSC Building","{MATH2110 : C|MATH2111 : C}","Math Teacher","0","01","06/08/2017","CSCI","fall","8:30-9:55","Graphs","2212", "", null);
		Course course8 = new Course("15","20","5","95","95","3.000","MTW","Algebra","12/12/2017","MATH","LSC Building","{MATH2110 : C|MATH2111 : C}","Math Teacher","11","01","06/08/2017","CSCI","fall","8:30-9:55","Algebra","2213", "", null);

		//TODO: POPULATE DATABASE
        //Management and Political Science
        //Course course9 = new Course("15","20","5","95","95","3.000","MTW","Algebra","12/12/2017","MATH","LSC Building","{MATH2110 : C|MATH2111 : C}","Math Teacher","11","01","06/08/2017","CSCI","fall","8:30-9:55","Algebra","2213", "", null);
		courselist.add(course1);
		courselist.add(course2);
		courselist.add(course3);
		courselist.add(course4);
		courselist.add(course5);
		courselist.add(course6);
		courselist.add(course7);
		courselist.add(course8);

		ArrayList<Course> current = new ArrayList<Course>();
		current.add(course1);
		current.add(course3);

		ArrayList<Course> completed = new ArrayList<Course>();
		completed.add(course4);


		ArrayList<Course> remaining = new ArrayList<Course>();
		remaining.add(course1);
		remaining.add(course2);
		remaining.add(course3);

		// email, String first_name, String completed, String current, String remaining, String last_name, String password, String username
		User user1 = new User("admin@dal.ca", "John", completed, current, remaining, "Doe", "admin", "admin");


		ArrayList<Course> current2 = new ArrayList<Course>();
		current2.add(course4);
		current2.add(course5);
		current2.add(course7);

		ArrayList<Course> completed2 = new ArrayList<Course>();
		completed2.add(course1);

		ArrayList<Course> remaining2 = new ArrayList<Course>();
		remaining2.add(course2);
		remaining2.add(course8);

		User user2 = new User("lolipop@dal.ca","Luke",completed2,current2,remaining2,"Duke","adri@tIk","B00878787");

		userlist.add(user1);
		userlist.add(user2);

	}


	//Methods to update course and user
	public void updateUser(User user) {
		//Given a user, change to given user
	}

	public void updateCourse(Course course) {
		for (int x =0; x<courselist.size(); x++) {
			if (courselist.get(x).getFaculty().equals(course.getFaculty()) && courselist.get(x).getYear().equals(course.getYear()) && courselist.get(x).getSection().equals(course.getSection())) {
				courselist.remove(x);
				courselist.add(course);
			}
		}
	}

	//Getter and setter methods
	public void addCourse(Course course) {
		courselist.add(course);
	}

	public Course getCourse(Course course) {
		return courselist.get(courselist.indexOf(course));
	}

	public void addUser(User user) {
		userlist.add(user);
	}

	public User getUser(User user) {
		return userlist.get(userlist.indexOf(user));
	}

	public ArrayList<User> getUserlist() {
		return userlist;
	}

	public ArrayList<Course> getCourselist() {
		return courselist;
	}

	public boolean exists() {
		return true;
	}
}