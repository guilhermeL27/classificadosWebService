package br.edu.ifsc.fln.vendas.classificadosifscapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 🔥 SOLUÇÃO PROFISSIONAL
    @Column(nullable = false)
    private String senha;

    private String nome;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Anuncio> anuncios = new ArrayList<>();
}