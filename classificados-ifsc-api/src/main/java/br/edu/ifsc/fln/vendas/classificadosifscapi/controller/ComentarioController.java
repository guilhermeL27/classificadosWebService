package br.edu.ifsc.fln.vendas.classificadosifscapi.controller;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsc.fln.vendas.classificadosifscapi.repository.ComentarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping
    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    @PostMapping
    public Comentario criar(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}