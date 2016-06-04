package com.eclinic.model;


public class Disease {

    private int id;
    private String name;
    private boolean isInfectious;

    public Disease() {
    }

    public Disease(String name, boolean isInfectious) {
        this.name = name;
        this.isInfectious = isInfectious;
    }

    public Disease(int id, String name, boolean isInfectious) {
        this.id = id;
        this.name = name;
        this.isInfectious = isInfectious;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInfectious() {
        return isInfectious;
    }

    public void setInfectious(boolean infectious) {
        isInfectious = infectious;
    }

    @Override
    public String toString() {
        return "Disease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isInfectious=" + isInfectious +
                '}';
    }
}
