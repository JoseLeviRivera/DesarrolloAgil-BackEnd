package com.unpa.edu.mx.desarrolloAgilScrum.Repository;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.HistoriaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriaUsuarioRepository extends JpaRepository<HistoriaUsuario, Long> { }
