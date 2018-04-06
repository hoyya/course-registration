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
     * @throws Exception
     */
    @Test
    public void timeCompleted() throws Exception {
        assertTrue(m2a.timeError("1200"));
    }

    /**
     * Tests if error is properly thrown.
     *
     * @throws Exception
     */
    @Test
    public void timeError() throws Exception {
        assertTrue(m2a.timeErrorThrown("1100"));
    }

    /**
     * Tests for conflicts and gives appropriate action
     *
     * @throws Exception
     */
    @Test
    public void timeDenied() throws Exception{
        assertTrue(m2a.deniedTime("1200"));
    }
}
