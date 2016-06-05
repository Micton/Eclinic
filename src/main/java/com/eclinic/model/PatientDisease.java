package com.eclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDisease {

    private int patientId;
    private int diseaseId;
    private String diseaseHistory;
    private int id;
}
