package com.unpa.edu.mx.desarrolloAgilScrum.Repository;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> { }
