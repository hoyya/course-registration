package com.dal_csci3130.course_registration;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class courseUnitTest {

    Course course = new Course("0", "20", "20", "120", "200","3.0","TR","software eng",
            "enddate","faculty","location","prereq","juliano","80","01","startdate","subject",
            "W","2:30-4","CSCI","3130", "", null );


    @Test
    public void exists() throws Exception{
        assertTrue(course.exists());
    }

    @Test
    public void print() throws Exception{
        assertTrue(course.stringify());
    }

    /*
    @Test
    public void dbtest() throws Exception{
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("courses");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               Course course = dataSnapshot.getValue(Course.class);
               System.out.println(course);
           }
           @Override
           public void onCancelled(DatabaseError error){
               Log.w(TAG, "Failed to read value.", error.toException());
           }
        });
    }
    */
}