package com.unpa.edu.mx.desarrolloAgilScrum.Services;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.HistoriaUsuario;

import java.util.List;
import java.util.Optional;

public interface HistoriaUsuarioService {
    void guardarHistoriaUsuario(HistoriaUsuario historiaUsuario);
    void actualizarHistoriaUsuario(HistoriaUsuario historiaUsuario);
    HistoriaUsuario buscarPorId(Long id);
    boolean eliminarPorId(Long id);
    Optional<List<HistoriaUsuario>> listarTodasHistoriasUsuario();
    boolean existeHistoriaUsuario(HistoriaUsuario historiaUsuario);
}

