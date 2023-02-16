package com.pruebaneoris.microservicios.app.prueba.models.entity;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;

@Entity
public class Cliente extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_cliente")
	private String idCliente;
	
	@Column(name = "contrasena")
	private String contrasena;
	
	@Column(name = "estado")
	private Boolean estado;
	
	@PrePersist
	public void prePersist() {
		this.idCliente = UUID.randomUUID().toString();
	}
	
	
	/*
	 * Getter and Setter
	 */
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + idCliente + ", contrasena=" + contrasena + ", estado=" + estado + ", getNombre()="
				+ getNombre() + ", getGenero()=" + getGenero() + ", getEdad()=" + getEdad() + ", getIdentificacion()="
				+ getIdentificacion() + ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
	
	
}