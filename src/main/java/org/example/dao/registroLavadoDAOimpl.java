package org.example.dao;
import org.example.model.registroLavado;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;
public class registroLavadoDAOimpl implements registroLavadoDAO {
    private final Connection connection;

    public registroLavadoDAOimpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void agregar (registroLavado r) {
        String sql = "INSERT INTO registrosLavado " +
                "(vehiculoID, servicioID, fechaLavado, horaInicio, horaFinal, precioTotal) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, r.getVehiculoID());
            statement.setInt(2, r.getServicioID());
            statement.setString(3, r.getFechaLavado());
            statement.setString(4, r.getHoraInicio());
            statement.setString(5, r.getHoraFin());
            statement.setDouble(6, r.getPrecioTotal());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public registroLavado leer (int registroLavadoID) {
        String sql = "SELECT * FROM registrosLavado WHERE registroID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, registroLavadoID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new registroLavado (
                        resultSet.getInt("registroLavadoID"),
                        resultSet.getInt("vehiculoID"),
                        resultSet.getInt("servicioID"),
                        resultSet.getString("fechaLavado"),
                        resultSet.getString("horaInicio"),
                        resultSet.getString("horaFin"),
                        resultSet.getDouble("precioTotal")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void eliminar(int registroLavadoID) {
        String sql = "DELETE FROM registrosLavado WHERE registroLavadoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, registroLavadoID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<registroLavado> listar() {
        List<registroLavado> registrosLavado= new ArrayList<>();

        String sql = "SELECT * FROM registrosLavado";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                registrosLavado.add(new registroLavado(
                        resultSet.getInt("registroLavadoID"),
                        resultSet.getInt("vehiculoID"),
                        resultSet.getInt("servicioID"),
                        resultSet.getString("fechaLavado"),
                        resultSet.getString("horaInicio"),
                        resultSet.getString("horaFin"),
                        resultSet.getDouble("precioTotal")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosLavado;
    }
    @Override
    public void actualizar(registroLavado r) {
        String sql = "UPDATE registrosLavado SET vehiculoID = ?, servicioID = ?, fechaLavado = ?, horaInicio = ?, horaFin = ?, precioTotal = ? WHERE registroLavadoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, r.getVehiculoID());
            statement.setInt(2, r.getServicioID());
            statement.setString(3, r.getFechaLavado());
            statement.setString(4, r.getHoraInicio());
            statement.setString(5, r.getHoraFin());
            statement.setDouble(6, r.getPrecioTotal());
            statement.setInt(7,r.getRegistroID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
