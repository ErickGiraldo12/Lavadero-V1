package org.example.dao;
import org.example.model.servicio;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;
public class servicioDAOimpl implements servicioDAO {
    private final Connection connection;

    public servicioDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregar (servicio s) {
        String sql = "INSERT INTO servicios " +
                "(nombre, precio) " +
                "VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, s.getNombre());
            statement.setDouble(2, s.getPrecio());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public servicio leer (int servicioID) {
        String sql = "SELECT * FROM servicios WHERE servicioID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, servicioID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new servicio (
                        resultSet.getInt("servicioID"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void eliminar(int servicioID) {
        String sql = "DELETE FROM servicios WHERE servicioID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, servicioID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<servicio> listar() {
        List<servicio> servicios = new ArrayList<>();

        String sql = "SELECT * FROM servicios";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                servicios.add(new servicio(
                        resultSet.getInt("servicioID"),
                        resultSet.getString("nombre"),
                        resultSet.getDouble("precio")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicios;
    }
    @Override
    public void actualizar(servicio s) {
        String sql = "UPDATE servicios SET nombre = ?, precio = ? WHERE servicioID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, s.getNombre());
            statement.setDouble(2, s.getPrecio());
            statement.setInt(3, s.getServicioID());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}