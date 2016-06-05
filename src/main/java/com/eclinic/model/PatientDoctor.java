package com.eclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDoctor {

    private int doctorId;
    private int patientId;
    private int id;
}
