package controller;

import entity.Campus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CampusRepository;

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
}