package com.eclinic.model;


public class PatientDoctor {

    private int doctorId;
    private int patientId;
    private int id;

    public PatientDoctor() {
    }

    public PatientDoctor(int doctorId, int patientId) {
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public PatientDoctor(int doctorId, int patientId, int id) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
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
        return "PatientDoctor{" +
                "doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", id=" + id +
                '}';
    }
}
