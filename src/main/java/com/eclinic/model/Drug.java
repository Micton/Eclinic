package com.eclinic.model;


public class Drug {

    private int id;
    private String tradeName;
    private String INNName;
    private int packing;
    private double dosagePerOneUnit;
    private int manufacturerId;
    private int drugTypeId;

    public Drug() {
    }

    public Drug(String tradeName, String INNName, int packing, double dosagePerOneUnit, int manufacturerId, int drugTypeId) {
        this.tradeName = tradeName;
        this.INNName = INNName;
        this.packing = packing;
        this.dosagePerOneUnit = dosagePerOneUnit;
        this.manufacturerId = manufacturerId;
        this.drugTypeId = drugTypeId;
    }

    public Drug(int id, String tradeName, String INNName, int packing, double dosagePerOneUnit, int manufacturerId, int drugTypeId) {
        this.id = id;
        this.tradeName = tradeName;
        this.INNName = INNName;
        this.packing = packing;
        this.dosagePerOneUnit = dosagePerOneUnit;
        this.manufacturerId = manufacturerId;
        this.drugTypeId = drugTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getINNName() {
        return INNName;
    }

    public void setINNName(String INNName) {
        this.INNName = INNName;
    }

    public int getPacking() {
        return packing;
    }

    public void setPacking(int packing) {
        this.packing = packing;
    }

    public double getDosagePerOneUnit() {
        return dosagePerOneUnit;
    }

    public void setDosagePerOneUnit(double dosagePerOneUnit) {
        this.dosagePerOneUnit = dosagePerOneUnit;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getDrugTypeId() {
        return drugTypeId;
    }

    public void setDrugTypeId(int drugTypeId) {
        this.drugTypeId = drugTypeId;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", tradeName='" + tradeName + '\'' +
                ", INNName='" + INNName + '\'' +
                ", packing=" + packing +
                ", dosagePerOneUnit=" + dosagePerOneUnit +
                ", manufacturerId=" + manufacturerId +
                ", drugTypeId=" + drugTypeId +
                '}';
    }
}
