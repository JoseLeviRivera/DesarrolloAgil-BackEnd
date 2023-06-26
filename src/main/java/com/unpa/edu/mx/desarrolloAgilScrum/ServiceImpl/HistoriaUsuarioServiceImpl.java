package com.unpa.edu.mx.desarrolloAgilScrum.ServiceImpl;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.HistoriaUsuario;
import com.unpa.edu.mx.desarrolloAgilScrum.Repository.HistoriaUsuarioRepository;
import com.unpa.edu.mx.desarrolloAgilScrum.Services.HistoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HistoriaUsuarioServiceImpl implements HistoriaUsuarioService {

    private final HistoriaUsuarioRepository historiaUsuarioRepository;

    @Autowired
    public HistoriaUsuarioServiceImpl(HistoriaUsuarioRepository historiaUsuarioRepository) {
        this.historiaUsuarioRepository = historiaUsuarioRepository;
    }

    @Override
    public void guardarHistoriaUsuario(HistoriaUsuario historiaUsuario) {
        historiaUsuarioRepository.save(historiaUsuario);
    }

    @Override
    public void actualizarHistoriaUsuario(HistoriaUsuario historiaUsuario) {
        historiaUsuarioRepository.save(historiaUsuario);
    }

    @Override
    public HistoriaUsuario buscarPorId(Long id) {
        return historiaUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    public boolean eliminarPorId(Long id) {
        if (historiaUsuarioRepository.existsById(id)) {
            historiaUsuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<List<HistoriaUsuario>> listarTodasHistoriasUsuario() {
        return Optional.of(historiaUsuarioRepository.findAll());
    }

    @Override
    public boolean existeHistoriaUsuario(HistoriaUsuario historiaUsuario) {
        return historiaUsuarioRepository.existsById(historiaUsuario.getId());
    }
}

