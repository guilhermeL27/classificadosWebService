package br.edu.ifsc.fln.vendas.classificadosifscapi.repository;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findByCategoriaId(Long categoriaId);
}