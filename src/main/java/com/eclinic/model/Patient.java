package com.eclinic.model;


import java.util.Date;

public class Patient {

    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String gender;
    private Date birthday;
    private int identificationNumber;
    private int bloodTypeId;

    public Patient() {
    }

    public Patient(String lastName, String firstName, String phone, String email, String gender, Date birthday, int identificationNumber, int bloodTypeId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.identificationNumber = identificationNumber;
        this.bloodTypeId = bloodTypeId;
    }

    public Patient(int id, String lastName, String firstName, String phone, String email, String gender, Date birthday, int identificationNumber, int bloodTypeId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.identificationNumber = identificationNumber;
        this.bloodTypeId = bloodTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public int getBloodTypeId() {
        return bloodTypeId;
    }

    public void setBloodTypeId(int bloodTypeId) {
        this.bloodTypeId = bloodTypeId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", identificationNumber=" + identificationNumber +
                ", bloodTypeId=" + bloodTypeId +
                '}';
    }
}
