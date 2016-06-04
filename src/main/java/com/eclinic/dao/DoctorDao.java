package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoctorDao implements EntityDao<Doctor> {

    private Connection connection;

    public DoctorDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(Doctor doctor) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into doctors(last_name, first_name, phone, email, specialisation_id) " +
                "values (?, ?, ?, ?, ?)")){
            preparedStatement.setString(1, doctor.getLastName());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getPhone());
            preparedStatement.setString(4, doctor.getEmail());
            preparedStatement.setInt(5, doctor.getSpecialisationId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM doctors WHERE id=?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE doctors SET last_name=?, first_name=?, phone=?, email=?," +
                " specialisation_id=? WHERE id=?")){
            preparedStatement.setString(1, doctor.getLastName());
            preparedStatement.setString(2, doctor.getFirstName());
            preparedStatement.setString(3, doctor.getPhone());
            preparedStatement.setString(4, doctor.getEmail());
            preparedStatement.setInt(5, doctor.getSpecialisationId());
            preparedStatement.setInt(6, doctor.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctors = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, last_name, first_name, phone, email," +
                "specialisation_id FROM doctors")){
            while (resultSet.next()){
                Doctor doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setSpecialisationId(resultSet.getInt("specialisation_id"));
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public Doctor getById(int id) {
        Doctor doctor = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, last_name, first_name, phone, email, specialisation_id FROM doctors WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                doctor = new Doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setLastName(resultSet.getString("last_name"));
                doctor.setFirstName(resultSet.getString("first_name"));
                doctor.setPhone(resultSet.getString("phone"));
                doctor.setEmail(resultSet.getString("email"));
                doctor.setSpecialisationId(resultSet.getInt("specialisation_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (doctor == null) throw new NoSuchElementException();
        return doctor;
    }
}
