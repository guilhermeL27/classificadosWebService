package br.edu.ifsc.fln.vendas.classificadosifscapi.controller;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ifsc.fln.vendas.classificadosifscapi.repository.CampusRepository;

import java.util.List;

@RestController
@RequestMapping("/api/campi")
public class CampusController {

    @Autowired
    private CampusRepository campusRepository;

    @GetMapping
    public List<Campus> listarTodos() {
        return campusRepository.findAll();
    }

    @PostMapping
    public Campus criar(@RequestBody Campus campus) {
        return campusRepository.save(campus);
    }

    @GetMapping("/{id}")
    public Campus buscarPorId(@PathVariable Long id) {
        return campusRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        campusRepository.deleteById(id);
    }
}