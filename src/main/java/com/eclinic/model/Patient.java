package com.eclinic.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
