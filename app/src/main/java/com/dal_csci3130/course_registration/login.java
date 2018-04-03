package com.dal_csci3130.course_registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {
    private User user;
    private static boolean enabled;
    private DataBase db;

    public static void setEnabled(boolean enabled) {
        login.enabled = enabled;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBase();
        db.initialize();
        System.out.println("size of course list after init: " + db.getCourselist().size());

        final EditText username = (EditText) findViewById(R.id.userName);
        final EditText password = (EditText) findViewById(R.id.password);
        Button register = (Button) findViewById(R.id.register);
        final Button login = (Button) findViewById(R.id.login);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(login.this, registration.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //function to validate user login credentials
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
    }

    public void validUser(String username, String password) {

        for (int i=0; i<db.getUserlist().size(); i++) {
            if (username.equals(db.getUserlist().get(i).getUsername()) && password.equals(db.getUserlist().get(i).getPassword())) {
                user = db.getUserlist().get(i);
                Intent intent = new Intent(login.this, profile.class);
                Bundle extras = new Bundle();
                extras.putSerializable("user", user);
                extras.putSerializable("database", db);
                intent.putExtras(extras);
                startActivityForResult(intent,0);
            } else {
                Toast.makeText(login.this, "Invalid Credentials!",
                        Toast.LENGTH_LONG).show();
            }

        }
    }
}


