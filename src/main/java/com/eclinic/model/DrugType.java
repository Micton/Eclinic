package com.eclinic.model;


public class DrugType {

    private int id;
    private String type;

    public DrugType() {
    }

    public DrugType(String type) {
        this.type = type;
    }

    public DrugType(int id, String type) {
        this.id = id;
        this.type = type;
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

    @Override
    public String toString() {
        return "DrugType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
