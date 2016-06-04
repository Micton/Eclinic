package com.eclinic.model;


public class PatientDisease {

    private int patientId;
    private int diseaseId;
    private String diseaseHistory;
    private int id;

    public PatientDisease() {
    }

    public PatientDisease(int patientId, int diseaseId, String diseaseHistory) {
        this.patientId = patientId;
        this.diseaseId = diseaseId;
        this.diseaseHistory = diseaseHistory;
    }

    public PatientDisease(int patientId, int diseaseId, String diseaseHistory, int id) {
        this.patientId = patientId;
        this.diseaseId = diseaseId;
        this.diseaseHistory = diseaseHistory;
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(int diseaseId) {
        this.diseaseId = diseaseId;
    }

    public String getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(String diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PatientDisease{" +
                "patientId=" + patientId +
                ", diseaseId=" + diseaseId +
                ", diseaseHistory='" + diseaseHistory + '\'' +
                ", id=" + id +
                '}';
    }
}
