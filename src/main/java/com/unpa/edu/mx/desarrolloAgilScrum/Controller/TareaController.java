package com.unpa.edu.mx.desarrolloAgilScrum.Controller;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Tarea;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {
    private final TareaService tareaService;

    @Autowired
    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarTarea(@RequestBody Tarea tarea) {
        tareaService.guardarTarea(tarea);
        return ResponseEntity.ok("Tarea guardada exitosamente");
    }

    @PutMapping("/")
    public ResponseEntity<String> actualizarTarea(@RequestBody Tarea tarea) {
        tareaService.actualizarTarea(tarea);
        return ResponseEntity.ok("Tarea actualizada exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> buscarPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.buscarPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminada = tareaService.eliminarPorId(id);
        if (eliminada) {
            return ResponseEntity.ok("Tarea eliminada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Tarea>> listarTodasTareas() {
        List<Tarea> tareas = tareaService.listarTodasTareas();
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/existe")
    public ResponseEntity<Boolean> existeTarea(@RequestBody Tarea tarea) {
        boolean existe = tareaService.existeTarea(tarea);
        return ResponseEntity.ok(existe);
    }
}

