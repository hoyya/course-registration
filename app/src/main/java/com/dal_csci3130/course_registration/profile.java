package com.dal_csci3130.course_registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class profile extends AppCompatActivity {

    public String Faculty, Major, Minor;
    public User user;
    public DataBase db;

    TextView welcome;
    TextView majorDisplay;
    TextView minorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
        System.out.println("Size of courselist in profile_view: " + db.getCourselist().size());

        //Displays the current users name in a welcome message
        welcome = findViewById(R.id.welcomeMessage);
        welcome.setText("Welcome, " + user.getFirst_name() + " " + user.getLast_name());

        majorDisplay = findViewById(R.id.majorDisplay);
        minorDisplay = findViewById(R.id.minorDisplay);

        majorDisplay.setText(user.getMajor());
        minorDisplay.setText(user.getMinor());

        Button classSearch = findViewById(R.id.classSearch);
        Button currentCourses = findViewById(R.id.currentCourses);
        Button remainingCourses = findViewById(R.id.remainingCourses);
        Button completedCourses = findViewById(R.id.completedCourses);

        Spinner facultySpinner = findViewById(R.id.facultyspinner);
        Spinner majorSpinner = findViewById(R.id.majorspinner);
        Spinner minorSpinner = findViewById(R.id.minorspinner);

        ArrayAdapter<CharSequence> facultyAdapter = ArrayAdapter.createFromResource(this, R.array.faculty_array2, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> majorAdapter = ArrayAdapter.createFromResource(this, R.array.major_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> minorAdapter = ArrayAdapter.createFromResource(this, R.array.minor_array, android.R.layout.simple_spinner_item);

        facultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        facultySpinner.setAdapter(facultyAdapter);
        majorSpinner.setAdapter(majorAdapter);
        minorSpinner.setAdapter(minorAdapter);

        Faculty = facultySpinner.getSelectedItem().toString();
        Major = majorSpinner.getSelectedItem().toString();
        Minor = minorSpinner.getSelectedItem().toString();

        classSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(profile.this, Main2Activity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("user", user);
                extras.putSerializable("database", db);
                intent.putExtras(extras);


                startActivityForResult(intent, 0);

            }
        });

        currentCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(profile.this, currentClasses.class);
                intent.putExtra("user", user);
                intent.putExtra("database", db);
                startActivityForResult(intent, 0);

            }
        });

        completedCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(profile.this, compltedCourses.class);
                intent.putExtra("user", user);
                intent.putExtra("database", db);
                startActivityForResult(intent, 0);

            }
        });

        remainingCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(profile.this, remainingClasses.class);
                intent.putExtra("user", user);
                intent.putExtra("database", db);
                startActivityForResult(intent, 0);

            }
        });


        facultySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Faculty = "BCS";
                        break;
                    case 1:
                        Faculty = "BACS";
                        break;
                    case 2:
                        Faculty = "BSC";
                        break;
                    case 3:
                        Faculty = "BCOMM";
                        break;
                    case 4:
                        Faculty = "BA";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        majorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Major = "Computer Science";
                        break;
                    case 1:
                        Major = "Mathematics";
                        break;
                    case 2:
                        Major = "Management";
                        break;
                    case 3:
                        Major = "Biology";
                        break;
                    case 4:
                        Major = "Political Science";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Minor = "Computer Science";
                        break;
                    case 1:
                        Minor = "Math";
                        break;
                    case 2:
                        Minor = "Management";
                        break;
                    case 3:
                        Minor = "Biology";
                        break;
                    case 4:
                        Minor = "Political Science";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        user = (User) extras.getSerializable("user");
        db = (DataBase) extras.getSerializable("database");
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


}
