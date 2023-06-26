package com.unpa.edu.mx.desarrolloAgilScrum.Repository;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> { }
