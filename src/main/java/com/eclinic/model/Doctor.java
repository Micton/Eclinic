package com.eclinic.model;


public class Doctor {

    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private int specialisationId;

    public Doctor() {
    }

    public Doctor(String lastName, String firstName, String phone, String email, int specialisationId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.specialisationId = specialisationId;
    }

    public Doctor(int id, String lastName, String firstName, String phone, String email, int specialisationId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.specialisationId = specialisationId;
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

    public int getSpecialisationId() {
        return specialisationId;
    }

    public void setSpecialisationId(int specialisationId) {
        this.specialisationId = specialisationId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", specialisationId=" + specialisationId +
                '}';
    }
}


