package com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Tarea;
import com.unpa.edu.mx.desarrolloAgilScrum.Repository.TareaRepository;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public void guardarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public void actualizarTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarPorId(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Tarea> listarTodasTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public boolean existeTarea(Tarea tarea) {
        return tareaRepository.existsById(tarea.getId());
    }
}

