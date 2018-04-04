package com.dal_csci3130.course_registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by brandonhussey on 2018-02-28.
 */
public class loginUnitTest {
    @Test
    public void validUser() throws Exception {

        String uName = "admin";
        String pass = "admin";

        boolean output = false;
        boolean expected = true;

        login loginTest = new login();
        loginTest.validUser(uName, pass);

        assertEquals(expected, output);
    }

}