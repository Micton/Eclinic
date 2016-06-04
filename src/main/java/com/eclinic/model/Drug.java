package com.eclinic.model;

import lombok.Data;

@Data
public class Drug {

    private int id;
    private String tradeName;
    private String INNName;
    private int packing;
    private double dosagePerOneUnit;
    private int manufacturerId;
    private int drugTypeId;
}
