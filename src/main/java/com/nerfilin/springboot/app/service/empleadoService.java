package com.nerfilin.springboot.app.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nerfilin.springboot.app.exceptions.UserNotFoundException;
import com.nerfilin.springboot.app.models.Empleado;
import com.nerfilin.springboot.app.repo.EmpleadoRepo;

@Service
public class empleadoService {

	private final EmpleadoRepo er;
	
	@Autowired
	public empleadoService(EmpleadoRepo empleadoRepo) {
		this.er = empleadoRepo;
	}
	
	public Empleado addEmpleado(Empleado empleado) {
		empleado.setCodEmpleado(UUID.randomUUID().toString());
		return er.save(empleado);
	}
	
	public List<Empleado> findAll() {
		return er.findAll();
	}
	
	public Empleado findEmpleadoById(Long id) {
		return er.findEmpleadoById(id)
				.orElseThrow(() -> new UserNotFoundException("El usuario con id: " + id + " no existe."));
	}
	
	public Empleado updateEmpleado(Empleado empleado) {
		return er.save(empleado);
	}
	
	public void deleteEmpleado(Long id) {
		er.deleteEmpleadoById(id);
	}
}
