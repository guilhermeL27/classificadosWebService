package br.edu.ifsc.fln.vendas.classificadosifscapi.controller;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsc.fln.vendas.classificadosifscapi.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}