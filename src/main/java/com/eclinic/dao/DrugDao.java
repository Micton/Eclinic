package com.eclinic.dao;


import com.eclinic.DbConnection;
import com.eclinic.model.Drug;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrugDao implements EntityDao<Drug> {

    private Connection connection;

    public DrugDao() {
        connection = DbConnection.getConnection();
    }

    @Override
    public void add(Drug drug) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO drugs (trade_name, inn_name, packing, dosage_per_one_unit, " +
                "manufacturer_id, drug_type_id) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, drug.getTradeName());
            preparedStatement.setString(2, drug.getINNName());
            preparedStatement.setInt(3, drug.getPacking());
            preparedStatement.setDouble(4, drug.getDosagePerOneUnit());
            preparedStatement.setInt(5, drug.getManufacturerId());
            preparedStatement.setInt(6, drug.getDrugTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM drugs WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Drug drug) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE drugs SET trade_name=?, inn_name=?, packing=?, dosage_per_one_unit=?," +
                "manufacturer_id=?, drug_type_id=? WHERE id=?")) {
            preparedStatement.setString(1, drug.getTradeName());
            preparedStatement.setString(2, drug.getINNName());
            preparedStatement.setInt(3, drug.getPacking());
            preparedStatement.setDouble(4, drug.getDosagePerOneUnit());
            preparedStatement.setInt(5, drug.getManufacturerId());
            preparedStatement.setInt(6, drug.getDrugTypeId());
            preparedStatement.setInt(7, drug.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Drug> getAll() {
        List<Drug> drugs = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery("SELECT id, trade_name, inn_name, packing," +
                "dosage_per_one_unit, manufacturer_id, drug_type_id FROM drugs")) {
            while (resultSet.next()){
                Drug drug = new Drug();
                drug.setId(resultSet.getInt("id"));
                drug.setTradeName(resultSet.getString("trade_name"));
                drug.setINNName(resultSet.getString("inn_name"));
                drug.setPacking(resultSet.getInt("packing"));
                drug.setDosagePerOneUnit(resultSet.getDouble("dosage_per_one_unit"));
                drug.setManufacturerId(resultSet.getInt("manufacturer_id"));
                drug.setDrugTypeId(resultSet.getInt("drug_type_id"));
                drugs.add(drug);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drugs;
    }

    @Override
    public Drug getById(int id) {
        Drug drug = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, trade_name, inn_name, packing," +
                "dosage_per_one_unit, manufacturer_id, drug_type_id FROM drugs WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                drug = new Drug();
                drug.setId(resultSet.getInt("id"));
                drug.setTradeName(resultSet.getString("trade_name"));
                drug.setINNName(resultSet.getString("inn_name"));
                drug.setPacking(resultSet.getInt("packing"));
                drug.setDosagePerOneUnit(resultSet.getDouble("dosage_per_one_unit"));
                drug.setManufacturerId(resultSet.getInt("manufacturer_id"));
                drug.setDrugTypeId(resultSet.getInt("drug_type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (drug == null) throw new NoSuchElementException();
        return drug;
    }
}
