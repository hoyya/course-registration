package com.dal_csci3130.course_registration;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private DataBase db = new DataBase();
    private String[] faculty_list = {"CSCI", "PHIL", "CHEM", "BIOL", "MATH"};
    private int[] year_list = {1,2,3,4,6,8};
    private int[] openspots_list = {0,10,20,50,100};

    SearchFilter search1;
    SearchFilter search2;
    SearchFilter search3;

    @Test
    public void unit_test1() throws Exception {
        search1 = new SearchFilter(db);
        search2 = new SearchFilter(db);
        search3 = new SearchFilter(db);

        db.initialize();
        assertEquals(4, 2 + 2);
    }
}