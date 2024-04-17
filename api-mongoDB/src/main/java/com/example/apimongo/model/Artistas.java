package com.example.apimongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(value = "Artistas")
@Data
public class Artistas {
	
	@Id
	private Integer id;
	private String nombre;
	private Integer edad;
	private String cancion;
	private String email;
	
	public Artistas() {
		
	}
	public Artistas(Integer id, String nombre, Integer edad, String cancion, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.cancion = cancion;
		this.email = email;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getCancion() {
		return cancion;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
