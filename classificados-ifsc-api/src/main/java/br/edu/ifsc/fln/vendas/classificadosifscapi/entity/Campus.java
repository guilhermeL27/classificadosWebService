package br.edu.ifsc.fln.vendas.classificadosifscapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campi")
@Data
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "campus")
    private List<Anuncio> anuncios = new ArrayList<>();
}