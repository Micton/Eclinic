package com.eclinic.model;


public class BloodType {

    private int id;
    private String type;
    private String rhesusFactor;

    public BloodType() {
    }

    public BloodType(String type, String rhesusFactor) {
        this.type = type;
        this.rhesusFactor = rhesusFactor;
    }

    public BloodType(int id, String type, String rhesusFactor) {
        this.id = id;
        this.type = type;
        this.rhesusFactor = rhesusFactor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRhesusFactor() {
        return rhesusFactor;
    }

    public void setRhesusFactor(String rhesusFactor) {
        this.rhesusFactor = rhesusFactor;
    }

    @Override
    public String toString() {
        return "BloodType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", rhesusFactor='" + rhesusFactor + '\'' +
                '}';
    }
}
