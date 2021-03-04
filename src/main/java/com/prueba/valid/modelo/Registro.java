package com.prueba.valid.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @date   03-03-2021
 * @author cmosquera <cmosquerara@gmail.com>
 * 
 */


@Entity
@Table(name = "registro")
public class Registro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idRegistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRegistro;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "procesado")
	private Boolean procesado;

	public Registro() {
		super();
	}

	
	
	public Registro(String nombre, String apellido, Boolean procesado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.procesado = procesado;
	}



	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Boolean getProcesado() {
		return procesado;
	}

	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}
	


}
