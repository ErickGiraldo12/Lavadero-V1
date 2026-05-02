package org.example.dao;

import org.example.model.vehiculo;

import java.util.List;

public interface vehiculoDAO {
    void agregar(vehiculo v);
    vehiculo leer(int vehiculoID);
    void eliminar(int vehiculoID);
    List<vehiculo> listar();
    void actualizar(vehiculo v);



}
