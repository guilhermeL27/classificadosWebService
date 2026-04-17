package br.edu.ifsc.fln.vendas.classificadosifscapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private List<Anuncio> anuncios = new ArrayList<>();
}