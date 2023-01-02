package com.nerfilin.springboot.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nerfilin.springboot.app.models.Empleado;
import com.nerfilin.springboot.app.service.empleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoResource {

	private final empleadoService es;
	
	public EmpleadoResource(empleadoService empleadoService) {
		this.es = empleadoService;
	}
	
	@CrossOrigin("*")
	@RequestMapping(path = "/listar",method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> getAllEmpleados() {
		List<Empleado> empleados = es.findAll();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/buscar/{id}",method = RequestMethod.GET)
	public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") Long id) {
		Empleado empleado = es.findEmpleadoById(id);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/agregar",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empleado> addEmpleado(@RequestBody Empleado empleado) {
		Empleado newEmpleado = es.addEmpleado(empleado);
		return new ResponseEntity<>(newEmpleado, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleado) {
		Empleado updateEmpleado = es.updateEmpleado(empleado);
		return new ResponseEntity<>(updateEmpleado, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/borrar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmpleado(@PathVariable("id") Long id) {
		es.deleteEmpleado(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
