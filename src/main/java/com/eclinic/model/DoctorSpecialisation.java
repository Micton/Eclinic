package com.eclinic.model;


public class DoctorSpecialisation {

    private int id;
    private String specialisation;

    public DoctorSpecialisation() {
    }

    public DoctorSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public DoctorSpecialisation(int id, String specialisation) {
        this.id = id;
        this.specialisation = specialisation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "DoctorSpecialisation{" +
                "id=" + id +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
