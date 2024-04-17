package com.example.apimongo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apimongo.model.Artistas;
import com.example.apimongo.repository.ArtistasRepository;
import com.example.apimongo.service.ArtistasService;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("/artistas")
public class ArtistasController {

	@Autowired
    private ArtistasService artistasService;
	
	
	@PostMapping
	public ResponseEntity<?> guardarArtista(@RequestBody Artistas artistas){
		try {
			Artistas artista = artistasService.guardarArtista(artistas);
			return new ResponseEntity<Artistas>(artista, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping
	public ResponseEntity<?> actualizarArtista(@RequestBody Artistas artistas){
		try {
			Artistas artista = artistasService.actualizarArtista(artistas);
			return new ResponseEntity<Artistas>(artista, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> actualizarParcialmenteArtista(@PathVariable Integer id, @RequestBody Map<String, Object> updates){
	    try {
	        Artistas artista = artistasService.actualizarParcialmente(id, updates);
	        return new ResponseEntity<Artistas>(artista, HttpStatus.OK);
	    } catch(Exception e) {
	        return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Artistas> obtenerArtistaPorId(@PathVariable Integer id) {
        Artistas artista = artistasService.obtenerArtistaPorId(id);
        return artista != null ? ResponseEntity.ok(artista) : ResponseEntity.notFound().build();
    }
	
  
    @RequestMapping(value = "/getAll", method = RequestMethod.HEAD)
    public ResponseEntity<?> handleHeadRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

  
    @RequestMapping(value = "/update", method = RequestMethod.OPTIONS)
    public String optionsUpdate() {
        return artistasService.optionsUpdate();
    }


	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarArtista(@PathVariable("id")Integer id){
		try {
			artistasService.eliminarArtista(id);
			return new ResponseEntity<String>("Artista Eliminado de la Base de Datos :)", HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping
	public ResponseEntity<?> mostrarArtistas(){
		try {
			List<Artistas> artista = artistasService.mostrarArtistas();
			return new ResponseEntity<List<Artistas>>(artista, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


		
}
