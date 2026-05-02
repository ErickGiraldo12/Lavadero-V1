package org.example.dao;
import org.example.model.registroLavado;
import java.util.List;

public interface registroLavadoDAO {
    void agregar(registroLavado r);
    registroLavado leer(int registroLavadoID);
    void eliminar(int registroLavadoID);
    List<registroLavado> listar();
    void actualizar(registroLavado r);



}
