package com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl;


import com.unpa.edu.mx.desarrolloAgilScrum.Model.Usuario;
import com.unpa.edu.mx.desarrolloAgilScrum.Repository.UsuarioRepository;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
       this.usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return this.usuarioRepository.findById(id).get();
    }

    @Override
    public boolean eliminarPorId(Long id) {
        Optional<Usuario> usuario = Optional.of(buscarPorId(id));
        usuario.ifPresent(t -> this.usuarioRepository.deleteById(id) );
        return usuario.isPresent();
    }

    @Override
    public Optional<List<Usuario>> listarTodosUsuarios() {
        return Optional.of(usuarioRepository.findAll());
    }

    @Override
    public boolean existeUsuario(Usuario usuario) {
        Optional<Usuario> usuario1 = Optional.of(buscarPorId(usuario.getId()));
        usuario1.ifPresent(t -> this.usuarioRepository.deleteById(usuario.getId()) );
        return usuario1.isPresent();
    }

}
