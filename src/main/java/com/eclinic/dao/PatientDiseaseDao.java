package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.PatientDisease;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PatientDiseaseDao implements EntityDao<PatientDisease>{

    private Connection connection;

    public PatientDiseaseDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(PatientDisease patientDisease) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients_diseases (patient_id, disease_id, disease_history) VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, patientDisease.getPatientId());
            preparedStatement.setInt(2, patientDisease.getDiseaseId());
            preparedStatement.setString(3, patientDisease.getDiseaseHistory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM patients_diseases WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PatientDisease patientDisease) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients_diseases SET patient_id=?, disease_id=?, disease_history=? WHERE id=?")) {
            preparedStatement.setInt(1, patientDisease.getPatientId());
            preparedStatement.setInt(2, patientDisease.getDiseaseId());
            preparedStatement.setString(3, patientDisease.getDiseaseHistory());
            preparedStatement.setInt(4, patientDisease.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PatientDisease> getAll() {
        List<PatientDisease> patientDiseases = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT patient_id, disease_id, disease_history, id FROM patients_diseases")) {
            while (resultSet.next()){
                PatientDisease patientDisease = new PatientDisease();
                patientDisease.setPatientId(resultSet.getInt("patient_id"));
                patientDisease.setDiseaseId(resultSet.getInt("disease_id"));
                patientDisease.setDiseaseHistory(resultSet.getString("disease_history"));
                patientDisease.setId(resultSet.getInt("id"));
                patientDiseases.add(patientDisease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientDiseases;
    }

    @Override
    public PatientDisease getById(int id) {
        PatientDisease patientDisease = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT patient_id, disease_id, disease_history, id FROM patients_diseases WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                patientDisease = new PatientDisease();
                patientDisease.setPatientId(resultSet.getInt("patient_id"));
                patientDisease.setDiseaseId(resultSet.getInt("disease_id"));
                patientDisease.setDiseaseHistory(resultSet.getString("disease_history"));
                patientDisease.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (patientDisease == null) throw new NoSuchElementException();
        return patientDisease;
    }
}
