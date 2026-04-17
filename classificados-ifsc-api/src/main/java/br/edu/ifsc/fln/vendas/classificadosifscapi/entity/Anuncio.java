package br.edu.ifsc.fln.vendas.classificadosifscapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "anuncios")
@Data
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private BigDecimal preco;

    private String imagemUrl;

    private LocalDateTime dataPublicacao = LocalDateTime.now();

    // 🔥 CORREÇÃO DO LOOP INFINITO
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @JsonIgnore
    @OneToMany(mappedBy = "anuncio", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();
}