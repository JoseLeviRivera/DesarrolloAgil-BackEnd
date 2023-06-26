package com.unpa.edu.mx.desarrolloAgilScrum.Services;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public abstract void guardarUsuario(Usuario usuario);
    public abstract void actualizarUsuario(Usuario usuario);
    public abstract Usuario buscarPorId(Long id);
    public abstract boolean eliminarPorId(Long id);

    public abstract Optional<List<Usuario>> listarTodosUsuarios();

    public abstract boolean existeUsuario(Usuario usuario);

}
