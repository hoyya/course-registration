package com.dal_csci3130.course_registration;

import android.app.Application;

/*
 set
   ((myApplication) this.getApplication()).setUser(user);

 get
   User user = ((myApplication) this.getApplication()).getUser();
*/

public class myApplication extends Application {

    private static User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        myApplication.user = user;
    }
}
