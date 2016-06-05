package com.eclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private int specialisationId;
}


