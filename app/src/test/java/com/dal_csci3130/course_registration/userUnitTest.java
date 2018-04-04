package com.dal_csci3130.course_registration;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class userUnitTest {

    ArrayList<Course> info = new ArrayList<Course>();

    User user = new User("email","john",info,info,info,"doe","password","johnydoe", "major", "minor");


    @Test
    public void exists() throws Exception{
        assertTrue(user.exists());
    }

    @Test
    public void print() throws Exception{
        assertTrue(user.stringify());
    }
}