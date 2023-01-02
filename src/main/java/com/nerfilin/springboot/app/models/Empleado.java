package com.nerfilin.springboot.app.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;

	private String nombre;

	private String email;

	private String trabajo;

	private String telefono;

	private String imageUrl;

	@Column(nullable = false, updatable = false)
	private String codEmpleado;

	private static final long serialVersionUID = 1L;

	public Empleado() {
	}

	public Empleado(Long id, String nombre, String email, String trabajo, String telefono, String imageUrl,
			String codEmpleado) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.trabajo = trabajo;
		this.telefono = telefono;
		this.imageUrl = imageUrl;
		this.codEmpleado = codEmpleado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", email=" + email + ", trabajo=" + trabajo + ", telefono="
				+ telefono + ", imageUrl=" + imageUrl + ", codEmpleado=" + codEmpleado + "]";
	}

}
