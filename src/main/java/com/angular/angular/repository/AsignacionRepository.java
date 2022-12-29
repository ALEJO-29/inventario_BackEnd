package com.angular.angular.repository;

import com.angular.angular.entity.Asignacion;
import com.angular.angular.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsignacionRepository extends JpaRepository<Asignacion, Integer> {

}
