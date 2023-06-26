package com.unpa.edu.mx.desarrolloAgilScrum.Repository;

import com.unpa.edu.mx.desarrolloAgilScrum.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
