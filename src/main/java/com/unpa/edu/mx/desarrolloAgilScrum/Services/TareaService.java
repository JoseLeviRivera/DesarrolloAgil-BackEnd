package com.unpa.edu.mx.desarrolloAgilScrum.Services;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Tarea;

import java.util.List;

public interface TareaService {
    void guardarTarea(Tarea tarea);
    void actualizarTarea(Tarea tarea);
    Tarea buscarPorId(Long id);
    boolean eliminarPorId(Long id);
    List<Tarea> listarTodasTareas();
    boolean existeTarea(Tarea tarea);
}

