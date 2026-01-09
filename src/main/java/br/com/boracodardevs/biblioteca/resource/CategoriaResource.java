package br.com.boracodardevs.biblioteca.resource;

import br.com.boracodardevs.biblioteca.domain.Categoria;
import br.com.boracodardevs.biblioteca.dtos.CategoriaDto;
import br.com.boracodardevs.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

	public ResponseEntity<List<CategoriaDto>> findAll(){
		var categorias = categoriaService.findAll();
		var categoriaDto = categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDto);
	}

}
