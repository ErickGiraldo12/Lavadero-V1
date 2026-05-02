package org.example.dao;
import org.example.model.servicio;

import java.util.List;
public interface servicioDAO {
    void agregar(servicio s);
    servicio leer(int servicioID);
    void eliminar(int servicioID);
    List<servicio> listar();
    void actualizar(servicio s);






}
