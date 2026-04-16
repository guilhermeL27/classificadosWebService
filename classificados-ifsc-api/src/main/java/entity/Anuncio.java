package entity;

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

    // Relacionamento: Muitos anúncios para um Usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relacionamento: Muitos anúncios para uma Categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Relacionamento: Muitos anúncios para um Campus
    @ManyToOne
    @JoinColumn(name = "campus_id")
    private Campus campus;

    // Relacionamento: Um anúncio pode ter muitos comentários
    @OneToMany(mappedBy = "anuncio", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();
}