package com.example.healthhubheroes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    private PatientAdapter patientAdapter;
    private List<Patient> patientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerViewPatients = findViewById(R.id.recyclerViewPatients);
        recyclerViewPatients.setLayoutManager(new LinearLayoutManager(this));

        // Initialize patient list
        patientList = new ArrayList<>();

        // Adding Ashish Mehra
        patientList.add(new Patient(
                "1234 567 890",       // Personal Health Number (PHN)
                "Ashish",             // First Name
                "Mehra",              // Last Name
                "K",                  // Middle Initial
                "Male",               // Sex
                "1990-01-15",         // Date of Birth (Format: yyyy-MM-dd)
                "Single",             // Marital Status
                "English",            // Language
                "Indian",             // Ethnicity
                "(123) 456-7890",     // Home Phone
                "123 Street Name",    // Street Address
                "10A",                // Apartment #
                "CityName",           // City
                "StateName",          // State/Province
                "12345",              // ZIP/Postal Code
                "Employed",           // Employment Status
                "Tech Corp",          // Employer
                "Software Developer", // Occupation
                "No known allergies"  // Patient Notes
        ));

        // Adding John Doe
        patientList.add(new Patient(
                "2345 678 901",       // Personal Health Number (PHN)
                "John",               // First Name
                "Doe",                // Last Name
                "B",                  // Middle Initial
                "Male",               // Sex
                "1978-11-21",         // Date of Birth (Format: yyyy-MM-dd)
                "Married",            // Marital Status
                "English",            // Language
                "Caucasian",          // Ethnicity
                "(234) 567-8901",     // Home Phone
                "456 Another St",     // Street Address
                "",                   // Apartment #
                "Cityville",          // City
                "StateName",          // State/Province
                "67890",              // ZIP/Postal Code
                "Self-Employed",      // Employment Status
                "Doe Enterprises",    // Employer
                "Consultant",         // Occupation
                "Diabetic"            // Patient Notes
        ));

        // Adding Jane Smith
        patientList.add(new Patient(
                "3456 789 012",       // Personal Health Number (PHN)
                "Jane",               // First Name
                "Smith",              // Last Name
                "C",                  // Middle Initial
                "Female",             // Sex
                "1995-05-30",         // Date of Birth (Format: yyyy-MM-dd)
                "Single",             // Marital Status
                "French",             // Language
                "African",            // Ethnicity
                "(345) 678-9012",     // Home Phone
                "789 Sample Rd",      // Street Address
                "25B",                // Apartment #
                "Metropolis",         // City
                "ProvinceName",       // State/Province
                "54321",              // ZIP/Postal Code
                "Student",            // Employment Status
                "University Name",    // Employer
                "Research Assistant", // Occupation
                "Vegetarian"          // Patient Notes
        ));

        // Add more patients as needed

        // Set adapter
        patientAdapter = new PatientAdapter(patientList);
        recyclerViewPatients.setAdapter(patientAdapter);
    }
}