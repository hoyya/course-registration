package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final EditText password = findViewById(R.id.password);
        final EditText username = findViewById(R.id.userName);
        final EditText firstName = findViewById(R.id.firstName);
        final EditText lastName = findViewById(R.id.lastName);
        final EditText email = findViewById(R.id.email);
        Button register = findViewById(R.id.register);
        Button cancel = findViewById(R.id.cancel);
        final TextView passConfirm = findViewById(R.id.passConfirm);
        final TextView emailConfirm = findViewById(R.id.emailConfirm);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validPassword(password.getText().toString()) && !TextUtils.isEmpty(username.getText().toString()) && !TextUtils.isEmpty(firstName.getText().toString()) && !TextUtils.isEmpty(lastName.getText().toString()) && !TextUtils.isEmpty(email.getText().toString())) {
                    startActivity(new Intent(registration.this, login.class));
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(registration.this, login.class));
            }
        });
    }

    public boolean validPassword(String pass) {

        boolean flag;
        final TextView passConfirm = findViewById(R.id.passConfirm);

        if (!checkPassword(pass)) {
            passConfirm.setText("Password must not be password");
            flag = false;

        } else if (!checkLength(pass)) {
            passConfirm.setText("Password must be at least 8 characters");
            flag = false;

        } else if (!checkSpecialChar(pass)) {
            passConfirm.setText("Password must contain a special character");
            flag = false;

        } else if (!checkDigit(pass)) {
            passConfirm.setText("Password must contain a number");
            flag = false;

        } else if (!checkUpperCase(pass)) {
            passConfirm.setText("Password must contain uppercase character");
            flag = false;

        } else {
            passConfirm.setText("Password validated!");
            flag = true;
        }

        return flag;

    }

    public boolean checkPassword(String pass) {

        boolean flag;

        //since case insensitve, make lowercase to test

        flag = !(pass != null && pass.toLowerCase().equals("password"));
        return flag;
    }

    public boolean checkLength(String pass) {

        boolean flag;

        //ensure greater or equal to 8
        flag = pass != null && pass.length() >= 8;
        return flag;
    }

    public boolean checkSpecialChar(String pass) {

        boolean flag;

        //create a pattern of the regex
        //match input to this pattern
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(pass);

        //if input matches the pattern then passes rule
        flag = matcher.find();
        return flag;
    }

    public boolean checkDigit(String pass) {

        boolean flag;

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(pass);

        //test for input containing number pattern
        flag = matcher.find();
        return flag;
    }

    public boolean checkUpperCase(String pass) {

        boolean flag;

        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(pass);

        //check for input in uppercase pattern
        flag = matcher.find();
        return flag;
    }
}
