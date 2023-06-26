package com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Proyecto;
import com.unpa.edu.mx.desarrolloAgilScrum.Repository.ProyectoRepository;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public void guardarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public void actualizarProyecto(Proyecto proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto buscarPorId(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarPorId(Long id) {
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<List<Proyecto>> listarTodosProyectos() {
        return Optional.of(proyectoRepository.findAll());
    }

    @Override
    public boolean existeProyecto(Proyecto proyecto) {
        return proyectoRepository.existsById(proyecto.getId());
    }
}

