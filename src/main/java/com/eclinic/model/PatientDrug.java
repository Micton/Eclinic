package com.eclinic.model;


public class PatientDrug {

    private int drugId;
    private int patientId;
    private int id;

    public PatientDrug() {
    }

    public PatientDrug(int drugId, int patientId) {
        this.drugId = drugId;
        this.patientId = patientId;
    }

    public PatientDrug(int drugId, int patientId, int id) {
        this.drugId = drugId;
        this.patientId = patientId;
        this.id = id;
    }

    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PatientDrug{" +
                "drugId=" + drugId +
                ", patientId=" + patientId +
                ", id=" + id +
                '}';
    }
}
