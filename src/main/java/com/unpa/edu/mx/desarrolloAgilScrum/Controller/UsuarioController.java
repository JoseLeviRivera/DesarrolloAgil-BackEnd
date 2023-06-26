package com.unpa.edu.mx.desarrolloAgilScrum.Controller;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Usuario;
import com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioServiceImp usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("Usuario guardado exitosamente");
    }

    @PutMapping("/")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
        return ResponseEntity.ok("Usuario actualizado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = usuarioService.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
        Optional<List<Usuario>> usuarios = usuarioService.listarTodosUsuarios();
        if (usuarios.isPresent()) {
            return ResponseEntity.ok(usuarios.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/existe")
    public ResponseEntity<Boolean> existeUsuario(@RequestBody Usuario usuario) {
        boolean existe = usuarioService.existeUsuario(usuario);
        return ResponseEntity.ok(existe);
    }
}

