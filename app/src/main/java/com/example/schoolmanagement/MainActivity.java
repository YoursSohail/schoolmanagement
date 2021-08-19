package com.example.schoolmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText regNoInput, nameInput, branchInput, marksInput, percentageInput, retrieveRegNo;
    Button btnSave, btnFind;
    TextView fetchedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        regNoInput = findViewById(R.id.regNoInput);
        nameInput = findViewById(R.id.nameInput);
        branchInput = findViewById(R.id.branchInput);
        marksInput = findViewById(R.id.marksInput);
        percentageInput = findViewById(R.id.percentageInput);
        retrieveRegNo = findViewById(R.id.retrieveRegNo);
        btnSave = findViewById(R.id.btnSave);
        btnFind = findViewById(R.id.btnFind);
        fetchedData = findViewById(R.id.fetchedData);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addStudent(
                        new Student(regNoInput.getText().toString(),
                                nameInput.getText().toString(),
                                branchInput.getText().toString(),
                                Integer.parseInt(marksInput.getText().toString()),
                                Integer.parseInt(percentageInput.getText().toString()))
                );

                Toast.makeText(MainActivity.this, "Student saved!", Toast.LENGTH_SHORT).show();
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = db.getStudent(retrieveRegNo.getText().toString());

                fetchedData.setText(
                        "Reg No: " + student.regNo + "\n" +
                                "Name: " + student.name + "\n" +
                                "Branch: " + student.branch + "\n" +
                                "Marks: " + student.marks + "\n" +
                                "Percentage: " + student.percentage
                );
            }
        });
    }
}