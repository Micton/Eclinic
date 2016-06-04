package com.eclinic.model;

import lombok.Data;

@Data
public class Doctor {

    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private int specialisationId;
}


