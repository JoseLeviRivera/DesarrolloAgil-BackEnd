package com.unpa.edu.mx.desarrolloAgilScrum.Controller;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Sprint;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    private final SprintService sprintService;

    @Autowired
    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @PostMapping("/")
    public ResponseEntity<String> guardarSprint(@RequestBody Sprint sprint) {
        sprintService.guardarSprint(sprint);
        return ResponseEntity.ok("Sprint guardado exitosamente");
    }

    @PutMapping("/")
    public ResponseEntity<String> actualizarSprint(@RequestBody Sprint sprint) {
        sprintService.actualizarSprint(sprint);
        return ResponseEntity.ok("Sprint actualizado exitosamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sprint> buscarPorId(@PathVariable Long id) {
        Sprint sprint = sprintService.buscarPorId(id);
        return ResponseEntity.ok(sprint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminado = sprintService.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Sprint eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Sprint>> listarTodosSprints() {
        List<Sprint> sprints = sprintService.listarTodosSprints();
        return ResponseEntity.ok(sprints);
    }

    @PostMapping("/existe")
    public ResponseEntity<Boolean> existeSprint(@RequestBody Sprint sprint) {
        boolean existe = sprintService.existeSprint(sprint);
        return ResponseEntity.ok(existe);
    }
}

