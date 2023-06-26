package com.unpa.edu.mx.desarrolloAgilScrum.Services;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Sprint;

import java.util.List;

public interface SprintService {
    void guardarSprint(Sprint sprint);
    void actualizarSprint(Sprint sprint);
    Sprint buscarPorId(Long id);
    boolean eliminarPorId(Long id);
    List<Sprint> listarTodosSprints();
    boolean existeSprint(Sprint sprint);
}

