package com.unpa.edu.mx.desarrolloAgilScrum.Services;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {
    void guardarProyecto(Proyecto proyecto);
    void actualizarProyecto(Proyecto proyecto);
    Proyecto buscarPorId(Long id);
    boolean eliminarPorId(Long id);
    Optional<List<Proyecto>> listarTodosProyectos();
    boolean existeProyecto(Proyecto proyecto);
}
