package com.eclinic;


import com.eclinic.dao.*;
import com.eclinic.model.*;


import java.util.List;

public class Clinic {


    public static void main(String[] args)  {

        Patient patient = new PatientDao().getById(1);
        Doctor doctor = new DoctorDao().getById(7);
        Clinic clinic = new Clinic();
        clinic.visitADoctor(patient, doctor);
        Disease disease = new DiseaseDao().getById(9);
        clinic.toDiagnose(patient, disease, "sd,dfmnasdnfbmasnfbgksdnbg");
        List<Drug> drugs = new DrugDao().getAll();
        clinic.prescribeTreatment(patient, drugs);


    }
    public void visitADoctor(Patient patient, Doctor doctor){
        PatientDoctorDao patientDoctorDao = new PatientDoctorDao();
        PatientDoctor patientDoctor = new PatientDoctor();
        patientDoctor.setPatientId(patient.getId());
        patientDoctor.setDoctorId(doctor.getId());
        patientDoctorDao.add(patientDoctor);
    }

    public void toDiagnose(Patient patient, Disease disease, String diseaseHistory){
        PatientDiseaseDao patientDiseaseDao = new PatientDiseaseDao();
        PatientDisease patientDisease = new PatientDisease();
        patientDisease.setPatientId(patient.getId());
        patientDisease.setDiseaseId(disease.getId());
        patientDisease.setDiseaseHistory(diseaseHistory);
        patientDiseaseDao.add(patientDisease);

    }

    public void prescribeTreatment(Patient patient, List<Drug> drugs){
        PatientDrugDao patientDrugDao = new PatientDrugDao();
        for (Drug drug: drugs){
            PatientDrug patientDrug = new PatientDrug();
            patientDrug.setDrugId(drug.getId());
            patientDrug.setPatientId(patient.getId());
            patientDrugDao.add(patientDrug);
        }
    }


}
