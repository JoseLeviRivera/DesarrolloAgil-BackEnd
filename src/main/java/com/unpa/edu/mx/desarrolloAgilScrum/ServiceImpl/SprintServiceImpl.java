package com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Sprint;
import com.unpa.edu.mx.desarrolloAgilScrum.Repository.SprintRepository;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;

    @Autowired
    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public void guardarSprint(Sprint sprint) {
        sprintRepository.save(sprint);
    }

    @Override
    public void actualizarSprint(Sprint sprint) {
        sprintRepository.save(sprint);
    }

    @Override
    public Sprint buscarPorId(Long id) {
        return sprintRepository.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarPorId(Long id) {
        if (sprintRepository.existsById(id)) {
            sprintRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Sprint> listarTodosSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public boolean existeSprint(Sprint sprint) {
        return sprintRepository.existsById(sprint.getId());
    }
}

