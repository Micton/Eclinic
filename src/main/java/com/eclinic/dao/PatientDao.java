package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PatientDao implements EntityDao<Patient> {

    private Connection connection;

    public PatientDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(Patient patient) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into patients(last_name, first_name, phone, email, gender, birthday," +
                " identification_number, blood_type_id) values (?, ?, ?, ?, ?, ?, ?, ?)")){

            preparedStatement.setString(1, patient.getLastName());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getPhone());
            preparedStatement.setString(4, patient.getEmail());
            preparedStatement.setString(5, patient.getGender());
            preparedStatement.setDate(6, new java.sql.Date(patient.getBirthday().getTime()));
            preparedStatement.setInt(7, patient.getIdentificationNumber());
            preparedStatement.setInt(8, patient.getBloodTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("delete from patients where id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Patient patient) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE patients SET last_name=?, first_name=?, phone=?, email=?, gender=?," +
                "birthday=?, identification_number=?, blood_type_id=? WHERE id=?")){
            preparedStatement.setString(1, patient.getLastName());
            preparedStatement.setString(2, patient.getFirstName());
            preparedStatement.setString(3, patient.getPhone());
            preparedStatement.setString(4, patient.getEmail());
            preparedStatement.setString(5, patient.getGender());
            preparedStatement.setDate(6, new java.sql.Date(patient.getBirthday().getTime()));
            preparedStatement.setInt(7, patient.getIdentificationNumber());
            preparedStatement.setInt(8, patient.getBloodTypeId());
            preparedStatement.setInt(9, patient.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, last_name, first_name, " +
                "phone, email, gender, birthday, identification_number, blood_type_id FROM patients")){
            while (resultSet.next()){
                Patient patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setLastName(resultSet.getString("last_name"));
                patient.setFirstName(resultSet.getString("first_name"));
                patient.setPhone(resultSet.getString("phone"));
                patient.setEmail(resultSet.getString("email"));
                patient.setGender(resultSet.getString("gender"));
                patient.setBirthday(resultSet.getDate("birthday"));
                patient.setIdentificationNumber(resultSet.getInt("identification_number"));
                patient.setBloodTypeId(resultSet.getInt("blood_type_id"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public Patient getById(int id) {
        Patient patient = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, last_name, first_name, phone, " +
                "email, gender, birthday, identification_number, blood_type_id FROM patients WHERE id=?")){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                patient = new Patient();
                patient.setId(resultSet.getInt("id"));
                patient.setLastName(resultSet.getString("last_name"));
                patient.setFirstName(resultSet.getString("first_name"));
                patient.setPhone(resultSet.getString("phone"));
                patient.setEmail(resultSet.getString("email"));
                patient.setGender(resultSet.getString("gender"));
                patient.setBirthday(resultSet.getDate("birthday"));
                patient.setIdentificationNumber(resultSet.getInt("identification_number"));
                patient.setBloodTypeId(resultSet.getInt("blood_type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (patient == null) throw new NoSuchElementException();
        return patient;
    }
}
