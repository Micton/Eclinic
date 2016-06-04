package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.PatientDoctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PatientDoctorDao implements EntityDao<PatientDoctor>{

    private Connection connection;

    public PatientDoctorDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(PatientDoctor patientDoctor) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO patients_doctors (doctor_id, patient_id) VALUES (?, ?)")) {
            preparedStatement.setInt(1, patientDoctor.getPatientId());
            preparedStatement.setInt(2, patientDoctor.getDoctorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM patients_doctors WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(PatientDoctor patientDoctor) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients_doctors SET doctor_id=?, patient_id=? WHERE id=?")) {
            preparedStatement.setInt(1, patientDoctor.getDoctorId());
            preparedStatement.setInt(2, patientDoctor.getPatientId());
            preparedStatement.setInt(3, patientDoctor.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PatientDoctor> getAll() {
        List<PatientDoctor> patientDoctors = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT doctor_id, patient_id, id FROM patients_doctors")) {
            while (resultSet.next()){
                PatientDoctor patientDoctor = new PatientDoctor();
                patientDoctor.setDoctorId(resultSet.getInt("doctor_id"));
                patientDoctor.setPatientId(resultSet.getInt("patient_id"));
                patientDoctor.setId(resultSet.getInt("id"));
                patientDoctors.add(patientDoctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientDoctors;
    }

    @Override
    public PatientDoctor getById(int id) {
        PatientDoctor patientDoctor = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT doctor_id, patient_id, id FROM patients_doctors WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                patientDoctor = new PatientDoctor();
                patientDoctor.setDoctorId(resultSet.getInt("doctor_id"));
                patientDoctor.setPatientId(resultSet.getInt("patient_id"));
                patientDoctor.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (patientDoctor == null)throw new NoSuchElementException();
        return patientDoctor;
    }
}


