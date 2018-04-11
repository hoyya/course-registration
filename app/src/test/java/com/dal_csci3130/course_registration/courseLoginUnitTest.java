package com.dal_csci3130.course_registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brandonhussey on 2018-02-28.
 */
public class courseLoginUnitTest {
    @Test
    public void validUser() throws Exception {

        String uName = "admin";
        String pass = "admin";


        CourseLogin courseLoginTest = new CourseLogin();
        boolean output = courseLoginTest.validUserTest(uName, pass);

        assertEquals(true, output);

    }

}