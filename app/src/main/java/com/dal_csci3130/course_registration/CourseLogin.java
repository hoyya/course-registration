package com.dal_csci3130.course_registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CourseLogin extends Activity {
    private User user;
    private static boolean enabled;
    private DataBase db;

    public static void setEnabled(boolean enabled) {
        CourseLogin.enabled = enabled;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBase();
        db.initialize();
        System.out.println("size of course list after init: " + db.getCourselist().size());

        final EditText username = findViewById(R.id.userName);
        final EditText password = findViewById(R.id.password);
        final Button login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //function to validate user CourseLogin credentials
                validUser(username.getText().toString(), password.getText().toString());

            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putSerializable("user", user);
        extras.putSerializable("database", db);
        intent.putExtras(extras);
        setResult(0, intent);
        finish();
    }

    /**
     *  Wait for results from initiated activity and update this activities params
     * @param requestCode = request code of activity
     * @param resultCode = result code of activity (expect 0)
     * @param data = bundles
     */

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
    }

    public void validUser(String username, String password) {

        for (int i = 0; i < db.getUserlist().size(); i++) {
            if (username.equals(db.getUserlist().get(i).getUsername()) && password.equals(db.getUserlist().get(i).getPassword())) {
                user = db.getUserlist().get(i);
                Intent intent = new Intent(CourseLogin.this, UserProfile.class);
                Bundle extras = new Bundle();
                extras.putSerializable("user", user);
                extras.putSerializable("database", db);
                intent.putExtras(extras);
                startActivityForResult(intent, 0);
            }
        }
    }
}


