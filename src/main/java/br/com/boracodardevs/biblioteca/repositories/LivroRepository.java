package br.com.boracodardevs.biblioteca.repositories;

import br.com.boracodardevs.biblioteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
