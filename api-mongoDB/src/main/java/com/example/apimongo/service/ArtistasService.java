package com.example.apimongo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.apimongo.model.Artistas;
import com.example.apimongo.repository.ArtistasRepository;
import java.util.Map;
import java.lang.reflect.Field;
import org.springframework.util.ReflectionUtils;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistasService {

    @Autowired
    private ArtistasRepository artistasRepository;

    public Artistas guardarArtista(Artistas artistas) {
        return artistasRepository.save(artistas);
    }
    
    public Artistas actualizarArtista(Artistas artistas) {
        return artistasRepository.save(artistas);
    }

    public void eliminarArtista(Integer id) {
        artistasRepository.deleteById(id);
    }

    public List<Artistas> mostrarArtistas() {
        return artistasRepository.findAll();
    }
    
    public Artistas actualizarParcialmente(Integer id, Map<String, Object> updates) {
        Artistas artista = artistasRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Artista no encontrado"));
        // Aplica cambios dinámicamente, dependiendo de qué campos están en `updates`
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Artistas.class, key);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, artista, value);
            }
        });
        return artistasRepository.save(artista);
    }
    public boolean existeArtista(Integer id) {
        return artistasRepository.existsById(id);
    }
    public Artistas obtenerArtistaPorId(Integer id) {
        return artistasRepository.findById(id).orElse(null);
    }
    public String optionsUpdate(){
        return "OPTIONS:  Inserta un nuevo artista, si el artista no existe, se creará automáticamente";
    }


}
