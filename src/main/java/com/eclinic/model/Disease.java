package com.eclinic.model;

import lombok.Data;

@Data
public class Disease {

    private int id;
    private String name;
    private boolean isInfectious;
}
