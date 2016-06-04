package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.Manufacturer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ManufacturerDao implements EntityDao<Manufacturer> {

    private Connection connection;

    public ManufacturerDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(Manufacturer manufacturer) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO manufacturers (manufacturer) VALUES (?)")) {
            preparedStatement.setString(1, manufacturer.getManufacturer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM manufacturers WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Manufacturer manufacturer) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE manufacturers SET manufacturer=? WHERE id=?")) {
            preparedStatement.setString(1, manufacturer.getManufacturer());
            preparedStatement.setInt(2, manufacturer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, manufacturer FROM manufacturers")) {
            while (resultSet.next()){
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setId(resultSet.getInt("id"));
                manufacturer.setManufacturer(resultSet.getString("manufacturer"));
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }

    @Override
    public Manufacturer getById(int id) {
        Manufacturer manufacturer = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, manufacturer FROM manufacturers WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                manufacturer = new Manufacturer();
                manufacturer.setId(resultSet.getInt("id"));
                manufacturer.setManufacturer(resultSet.getString("manufacturer"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (manufacturer == null) throw new NoSuchElementException();
        return manufacturer;
    }
}
