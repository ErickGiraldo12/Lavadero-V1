package org.example.dao;
import org.example.model.cliente;
import java.util.List;
public interface clienteDAO {
    void agregar(cliente c);
    cliente leer(int clienteID);
    void eliminar(int clienteID);
    List<cliente> listar();
    void actualizar(cliente c);







}
