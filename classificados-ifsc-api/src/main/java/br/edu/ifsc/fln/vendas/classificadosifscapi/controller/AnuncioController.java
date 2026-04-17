package br.edu.ifsc.fln.vendas.classificadosifscapi.controller;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Anuncio;
import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Usuario;
import br.edu.ifsc.fln.vendas.classificadosifscapi.repository.AnuncioRepository;
import br.edu.ifsc.fln.vendas.classificadosifscapi.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anuncios")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // LISTAR
    @GetMapping
    public List<Anuncio> listarTodos() {
        return anuncioRepository.findAll();
    }

    // 🔥 CRIAR (SIMPLIFICADO — SEM ERRO)
    @PostMapping
    public Anuncio criar(@RequestBody Anuncio anuncio) {

        // força o usuário manualmente (pra não dar erro)
        Usuario usuario = usuarioRepository.findById(4L).orElse(null);

        anuncio.setUsuario(usuario);

        return anuncioRepository.save(anuncio);
    }

    // BUSCAR
    @GetMapping("/{id}")
    public Anuncio buscarPorId(@PathVariable Long id) {
        return anuncioRepository.findById(id).orElse(null);
    }

    // FILTRO
    @GetMapping("/categoria/{id}")
    public List<Anuncio> buscarPorCategoria(@PathVariable Long id) {
        return anuncioRepository.findByCategoriaId(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        anuncioRepository.deleteById(id);
    }
}