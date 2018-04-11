package com.dal_csci3130.course_registration;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by AJ on 2018-03-19.
 */

public class timeTest {

    //Creates activity to be used
    private Search m2a = new Search();


    /**
     * Tests if for time conflict.
     *
     * @throws Exception 1
     */
    @Test
    public void timeCompleted() throws Exception {
        assertTrue(m2a.timeError("8:30-9:55"));
    }

    /**
     * Tests if error is properly thrown.
     *
     * @throws Exception 2
     */
    @Test
    public void timeError() throws Exception {
        assertTrue(m2a.timeErrorThrown("8:30-9:55"));
    }

    /**
     * Tests for conflicts and gives appropriate action
     *
     * @throws Exception 3
     */
    @Test
    public void timeDenied() throws Exception{
        assertTrue(m2a.deniedTime("8:30-9:55"));
    }
}
