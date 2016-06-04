package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.PatientDrug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PatientDrugDao implements EntityDao<PatientDrug>{

    private Connection connection;

    public PatientDrugDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(PatientDrug patientDrug) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients_drugs (drug_id, patient_id) VALUES (?, ?)")) {
            preparedStatement.setInt(1, patientDrug.getDrugId());
            preparedStatement.setInt(2, patientDrug.getPatientId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM patients_drugs WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PatientDrug patientDrug) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients_drugs SET drug_id=?, patient_id=? WHERE id=?")) {
            preparedStatement.setInt(1, patientDrug.getDrugId());
            preparedStatement.setInt(2, patientDrug.getPatientId());
            preparedStatement.setInt(3, patientDrug.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PatientDrug> getAll() {
        List<PatientDrug> patientDrugs = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT drug_id, patient_id, id FROM patients_drugs")) {
            while (resultSet.next()){
                PatientDrug patientDrug = new PatientDrug();
                patientDrug.setDrugId(resultSet.getInt("drug_id"));
                patientDrug.setPatientId(resultSet.getInt("patient_id"));
                patientDrug.setId(resultSet.getInt("id"));
                patientDrugs.add(patientDrug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientDrugs;
    }

    @Override
    public PatientDrug getById(int id) {
        PatientDrug patientDrug = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT drug_id, patient_id, id FROM patients_drugs WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                patientDrug = new PatientDrug();
                patientDrug.setDrugId(resultSet.getInt("drug_id"));
                patientDrug.setPatientId(resultSet.getInt("patient_id"));
                patientDrug.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (patientDrug == null) throw new NoSuchElementException();
        return patientDrug;
    }
}
