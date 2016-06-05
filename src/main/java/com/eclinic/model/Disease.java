package com.eclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disease {

    private int id;
    private String name;
    private boolean isInfectious;
}
