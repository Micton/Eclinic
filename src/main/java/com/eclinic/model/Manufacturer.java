package com.eclinic.model;


public class Manufacturer {

    private int id;
    private String manufacturer;

    public Manufacturer() {
    }

    public Manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturer(int id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
