package com.eclinic.model;

import lombok.Data;

@Data
public class PatientDisease {

    private int patientId;
    private int diseaseId;
    private String diseaseHistory;
    private int id;
}
