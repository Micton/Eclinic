package com.eclinic.model;


import lombok.Data;

import java.util.Date;

@Data
public class Patient {

    private int id;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String gender;
    private Date birthday;
    private int identificationNumber;
    private int bloodTypeId;
}
