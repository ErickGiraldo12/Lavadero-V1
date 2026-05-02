package org.example.dao;
import org.example.model.cliente;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;
public class clienteDAOimpl implements clienteDAO {
    private final Connection connection;

    public clienteDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregar (cliente c) {
        String sql = "INSERT INTO clientes " +
                "(nombre, apellido, telefono, email, direccion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellido());
            statement.setString(3, c.getTelefono());
            statement.setString(4, c.getEmail());
            statement.setString(5, c.getDireccion());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public cliente leer (int clienteID) {
        String sql = "SELECT * FROM clientes WHERE clienteID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, clienteID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new cliente (
                        resultSet.getInt("clienteID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"),
                        resultSet.getString("direccion")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void eliminar(int clienteID) {
        String sql = "DELETE FROM clientes WHERE clienteID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, clienteID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<cliente> listar() {
        List<cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                clientes.add(new cliente(
                        resultSet.getInt("clienteID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellido"),
                        resultSet.getString("telefono"),
                        resultSet.getString("email"),
                        resultSet.getString("direccion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
    @Override
    public void actualizar(cliente c) {
        String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, email = ?, direccion = ? WHERE clienteID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getApellido());
            statement.setString(3, c.getTelefono());
            statement.setString(4, c.getEmail());
            statement.setString(5, c.getDireccion());
            statement.setInt(6, c.getClienteID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
