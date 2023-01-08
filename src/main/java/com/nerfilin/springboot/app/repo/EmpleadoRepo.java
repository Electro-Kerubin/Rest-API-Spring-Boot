package com.nerfilin.springboot.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nerfilin.springboot.app.models.Empleado;

public interface EmpleadoRepo extends JpaRepository<Empleado, Long> {

	// void deleteEmpleadoById(Long id);

	Optional<Empleado> findEmpleadoById(Long id);

}
