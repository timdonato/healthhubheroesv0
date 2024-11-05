package com.example.healthhubheroes;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Patient {
    // Basic patient identification fields
    private String personalHealthNumber;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String sex;
    private String dateOfBirth;
    private String maritalStatus;
    private String language;
    private String ethnicity;

    // Contact information
    private String homePhone;
    private String streetAddress;
    private String apartmentNumber;
    private String city;
    private String stateOrProvince;
    private String zipOrPostalCode;

    // Employment information
    private String employmentStatus;
    private String employer;
    private String occupation;

    // Additional fields
    private String patientNotes;

    // Constructor
    public Patient(String personalHealthNumber, String firstName, String lastName, String middleInitial, String sex,
                   String dateOfBirth, String maritalStatus, String language, String ethnicity, String homePhone,
                   String streetAddress, String apartmentNumber, String city, String stateOrProvince,
                   String zipOrPostalCode, String employmentStatus, String employer, String occupation,
                   String patientNotes) {
        this.personalHealthNumber = personalHealthNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.language = language;
        this.ethnicity = ethnicity;
        this.homePhone = homePhone;
        this.streetAddress = streetAddress;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.stateOrProvince = stateOrProvince;
        this.zipOrPostalCode = zipOrPostalCode;
        this.employmentStatus = employmentStatus;
        this.employer = employer;
        this.occupation = occupation;
        this.patientNotes = patientNotes;
    }

    // Getters and Setters for each field

    public String getPersonalHealthNumber() {
        return personalHealthNumber;
    }

    public void setPersonalHealthNumber(String personalHealthNumber) {
        this.personalHealthNumber = personalHealthNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }

    public String getZipOrPostalCode() {
        return zipOrPostalCode;
    }

    public void setZipOrPostalCode(String zipOrPostalCode) {
        this.zipOrPostalCode = zipOrPostalCode;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPatientNotes() {
        return patientNotes;
    }

    public void setPatientNotes(String patientNotes) {
        this.patientNotes = patientNotes;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int getAge() {
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            return 0; // or handle this case as needed
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthDate, currentDate).getYears();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return 0; // Handle invalid date format
        }
    }
}
