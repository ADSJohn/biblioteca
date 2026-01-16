package br.com.boracodardevs.biblioteca.service;

import br.com.boracodardevs.biblioteca.domain.Categoria;
import br.com.boracodardevs.biblioteca.dtos.CategoriaDto;
import br.com.boracodardevs.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria findById(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

	public Categoria update(Integer id, CategoriaDto categoriaDto) {
		var categoria = findById(id);
		categoria.setNome(categoriaDto.getNome());
		categoria.setDescricao(categoriaDto.getDescricao());
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		var categoria = findById(id);
		categoriaRepository.delete(categoria);
	}
}
