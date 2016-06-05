package com.eclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodType {

    private int id;
    private String type;
    private String rhesusFactor;

}
