package controller;

import entity.Anuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.AnuncioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    // Listar todos os anúncios
    @GetMapping
    public List<Anuncio> listarTodos() {
        return anuncioRepository.findAll();
    }

    // Criar um novo anúncio
    @PostMapping
    public Anuncio criar(@RequestBody Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    // Buscar um anúncio por ID
    @GetMapping("/{id}")
    public ResponseEntity<Anuncio> buscarPorId(@PathVariable Long id) {
        return anuncioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um anúncio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!anuncioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        anuncioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}