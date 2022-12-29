package com.angular.angular.repository;

import com.angular.angular.entity.Producto;
import com.angular.angular.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Producto> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
