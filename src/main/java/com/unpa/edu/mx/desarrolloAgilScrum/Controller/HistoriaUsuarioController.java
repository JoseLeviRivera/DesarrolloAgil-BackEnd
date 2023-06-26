package com.unpa.edu.mx.desarrolloAgilScrum.Controller;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.HistoriaUsuario;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.HistoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historias-usuario")
public class HistoriaUsuarioController {
    private final HistoriaUsuarioService historiaUsuarioService;

    @Autowired
    public HistoriaUsuarioController(HistoriaUsuarioService historiaUsuarioService) {
        this.historiaUsuarioService = historiaUsuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarHistoriaUsuario(@RequestBody HistoriaUsuario historiaUsuario) {
        historiaUsuarioService.guardarHistoriaUsuario(historiaUsuario);
        return ResponseEntity.ok("Historia de usuario guardada exitosamente");
    }

    @PutMapping("/")
    public ResponseEntity<String> actualizarHistoriaUsuario(@RequestBody HistoriaUsuario historiaUsuario) {
        historiaUsuarioService.actualizarHistoriaUsuario(historiaUsuario);
        return ResponseEntity.ok("Historia de usuario actualizada exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaUsuario> buscarPorId(@PathVariable Long id) {
        HistoriaUsuario historiaUsuario = historiaUsuarioService.buscarPorId(id);
        return ResponseEntity.ok(historiaUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminada = historiaUsuarioService.eliminarPorId(id);
        if (eliminada) {
            return ResponseEntity.ok("Historia de usuario eliminada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<HistoriaUsuario>> listarTodasHistoriasUsuario() {
        Optional<List<HistoriaUsuario>> historiasUsuario = historiaUsuarioService.listarTodasHistoriasUsuario();
        if (historiasUsuario.isPresent()) {
            return ResponseEntity.ok(historiasUsuario.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/existe")
    public ResponseEntity<Boolean> existeHistoriaUsuario(@RequestBody HistoriaUsuario historiaUsuario) {
        boolean existe = historiaUsuarioService.existeHistoriaUsuario(historiaUsuario);
        return ResponseEntity.ok(existe);
    }
}

