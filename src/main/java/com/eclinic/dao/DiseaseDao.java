package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.Disease;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DiseaseDao implements EntityDao<Disease> {

    private Connection connection;

    public DiseaseDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(Disease disease) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO diseases (disease, is_infectious) VALUES (?, ?)")){
            preparedStatement.setString(1, disease.getName());
            preparedStatement.setBoolean(2, disease.isInfectious());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM diseases WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Disease disease) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE diseases SET disease=?, is_infectious=? WHERE id=?")) {
            preparedStatement.setString(1, disease.getName());
            preparedStatement.setBoolean(2, disease.isInfectious());
            preparedStatement.setInt(3, disease.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Disease> getAll() {
        List<Disease> diseases = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, disease, is_infectious FROM diseases")) {
            while (resultSet.next()){
                Disease disease = new Disease();
                disease.setId(resultSet.getInt("id"));
                disease.setName(resultSet.getString("disease"));
                disease.setInfectious(resultSet.getBoolean("is_infectious"));
                diseases.add(disease);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diseases;
    }

    @Override
    public Disease getById(int id) {
        Disease disease = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, disease, is_infectious FROM diseases WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                disease = new Disease();
                disease.setId(resultSet.getInt("id"));
                disease.setName(resultSet.getString("disease"));
                disease.setInfectious(resultSet.getBoolean("is_infectious"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (disease == null) throw new NoSuchElementException();
        return disease;
    }
}
