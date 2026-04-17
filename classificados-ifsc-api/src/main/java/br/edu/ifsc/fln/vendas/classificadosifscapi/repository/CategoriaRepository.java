package br.edu.ifsc.fln.vendas.classificadosifscapi.repository;

import br.edu.ifsc.fln.vendas.classificadosifscapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}