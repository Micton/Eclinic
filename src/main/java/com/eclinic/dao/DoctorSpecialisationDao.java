package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.DoctorSpecialisation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoctorSpecialisationDao implements EntityDao<DoctorSpecialisation> {

    private Connection connection;

    public DoctorSpecialisationDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(DoctorSpecialisation doctorSpecialisation) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO doctors_specialisation (id, specialisation) VALUES (?, ?)")) {
            preparedStatement.setInt(1, doctorSpecialisation.getId());
            preparedStatement.setString(2, doctorSpecialisation.getSpecialisation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM doctors_specialisation WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DoctorSpecialisation doctorSpecialisation) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE doctors_specialisation SET specialisation=? WHERE id=?")) {
            preparedStatement.setString(1, doctorSpecialisation.getSpecialisation());
            preparedStatement.setInt(2, doctorSpecialisation.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DoctorSpecialisation> getAll() {
        List<DoctorSpecialisation> doctorSpecialisations = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, specialisation FROM doctors_specialisation")) {
            while (resultSet.next()){
                DoctorSpecialisation specialisation = new DoctorSpecialisation();
                specialisation.setId(resultSet.getInt("id"));
                specialisation.setSpecialisation(resultSet.getString("specialisation"));
                doctorSpecialisations.add(specialisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctorSpecialisations;
    }

    @Override
    public DoctorSpecialisation getById(int id) {
        DoctorSpecialisation specialisation = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, specialisation FROM doctors_specialisation WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                specialisation = new DoctorSpecialisation();
                specialisation.setId(resultSet.getInt("id"));
                specialisation.setSpecialisation(resultSet.getString("specialisation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (specialisation == null) throw new NoSuchElementException();
        return specialisation;
    }
}
