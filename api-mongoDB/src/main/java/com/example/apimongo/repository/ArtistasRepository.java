package com.example.apimongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.apimongo.model.Artistas;

@Repository
public interface ArtistasRepository extends MongoRepository<Artistas,Integer>{
	
	
}
