package org.example.dao;
import org.example.model.vehiculo;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;
public class vehiculoDAOimpl implements vehiculoDAO {
    private final Connection connection;

    public vehiculoDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregar (vehiculo v) {
        String sql = "INSERT INTO vehiculos " +
                "(clienteID, marca, modelo, placa, color, tipo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, v.getClienteID());
            statement.setString(2, v.getMarca());
            statement.setString(3, v.getModelo());
            statement.setString(4, v.getPlaca());
            statement.setString(5, v.getColor());
            statement.setString(6, v.getTipo());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public vehiculo leer (int vehiculoID) {
        String sql = "SELECT * FROM vehiculos WHERE vehiculoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, vehiculoID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new vehiculo (
                        resultSet.getInt("vehiculoID"),
                        resultSet.getInt("clienteID"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("placa"),
                        resultSet.getString("color"),
                        resultSet.getString("tipo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void eliminar(int vehiculoID) {
        String sql = "DELETE FROM vehiculos WHERE vehiculoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vehiculoID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<vehiculo> listar() {
        List<vehiculo> vehiculos = new ArrayList<>();

        String sql = "SELECT * FROM vehiculos";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                vehiculos.add(new vehiculo(
                        resultSet.getInt("vehiculoID"),
                        resultSet.getInt("clienteID"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("placa"),
                        resultSet.getString("color"),
                        resultSet.getString("tipo")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehiculos;
    }
    @Override
    public void actualizar(vehiculo v) {
        String sql = "UPDATE vehiculos SET clienteID = ?, marca = ?, modelo = ?, placa = ?, color = ?, tipo = ? WHERE vehiculoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, v.getClienteID());
            statement.setString(2, v.getMarca());
            statement.setString(3, v.getModelo());
            statement.setString(4, v.getPlaca());
            statement.setString(5, v.getColor());
            statement.setString(6, v.getTipo());
            statement.setInt(7, v.getVehiculoID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}