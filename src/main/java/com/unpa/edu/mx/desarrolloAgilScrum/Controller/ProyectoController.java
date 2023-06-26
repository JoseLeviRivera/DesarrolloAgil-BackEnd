package com.unpa.edu.mx.desarrolloAgilScrum.Controller;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Proyecto;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    private final ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.guardarProyecto(proyecto);
        return ResponseEntity.ok("Proyecto guardado exitosamente");
    }

    @PutMapping("/")
    public ResponseEntity<String> actualizarProyecto(@RequestBody Proyecto proyecto) {
        proyectoService.actualizarProyecto(proyecto);
        return ResponseEntity.ok("Proyecto actualizado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> buscarPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.buscarPorId(id);
        return ResponseEntity.ok(proyecto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = proyectoService.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Proyecto eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Proyecto>> listarTodosProyectos() {
        Optional<List<Proyecto>> proyectos = proyectoService.listarTodosProyectos();
        if (proyectos.isPresent()) {
            return ResponseEntity.ok(proyectos.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/existe")
    public ResponseEntity<Boolean> existeProyecto(@RequestBody Proyecto proyecto) {
        boolean existe = proyectoService.existeProyecto(proyecto);
        return ResponseEntity.ok(existe);
    }
}

