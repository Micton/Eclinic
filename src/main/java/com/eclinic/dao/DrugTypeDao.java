package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.DrugType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrugTypeDao implements EntityDao<DrugType>{

    private Connection connection;

    public DrugTypeDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(DrugType drugType) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO drug_type (drug_type) VALUES (?)")) {
            preparedStatement.setString(1, drugType.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM drug_type WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DrugType drugType) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE drug_type SET drug_type=? WHERE id=?")) {
            preparedStatement.setString(1, drugType.getType());
            preparedStatement.setInt(2, drugType.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DrugType> getAll() {
        List<DrugType> drugTypes = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, drug_type FROM drug_type")) {
            while (resultSet.next()){
                DrugType drugType = new DrugType();
                drugType.setId(resultSet.getInt("id"));
                drugType.setType(resultSet.getString("drug_type"));
                drugTypes.add(drugType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugTypes;
    }

    @Override
    public DrugType getById(int id) {
        DrugType drugType = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, drug_type FROM drug_type WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                drugType = new DrugType();
                drugType.setId(resultSet.getInt("id"));
                drugType.setType(resultSet.getString("drug_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (drugType == null) throw new NoSuchElementException();
        return drugType;
    }
}
