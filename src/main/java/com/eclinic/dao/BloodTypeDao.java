package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.BloodType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BloodTypeDao implements EntityDao<BloodType>{

    private Connection connection;

    public BloodTypeDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public BloodType getById(int id) {
        BloodType bloodType = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, blood_type, rhesus_factor FROM blood_type WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                bloodType = new BloodType();
                bloodType.setId(resultSet.getInt("id"));
                bloodType.setType(resultSet.getString("blood_type"));
                bloodType.setRhesusFactor(resultSet.getString("rhesus_factor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (bloodType == null) throw new NoSuchElementException();
        return bloodType;
    }

    @Override
    public void add(BloodType bloodType) {
        // No implementation necessary
    }

    @Override
    public void delete(int id) {
        // No implementation necessary
    }

    @Override
    public void update(BloodType bloodType) {
        // No implementation necessary
    }

    @Override
    public List<BloodType> getAll() {
        List<BloodType> bloodTypes = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, blood_type, rhesus_factor FROM blood_type")){
            while (resultSet.next()){
                BloodType bloodType = new BloodType();
                bloodType.setId(resultSet.getInt("id"));
                bloodType.setType(resultSet.getString("blood_type"));
                bloodType.setRhesusFactor(resultSet.getString("rhesus_factor"));
                bloodTypes.add(bloodType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodTypes;
    }
}
