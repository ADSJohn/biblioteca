package br.com.boracodardevs.biblioteca.resource;

import br.com.boracodardevs.biblioteca.domain.Categoria;
import br.com.boracodardevs.biblioteca.dtos.CategoriaDto;
import br.com.boracodardevs.biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria categoria = categoriaService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }

    @GetMapping
	public ResponseEntity<List<CategoriaDto>> findAll(){
		var categorias = categoriaService.findAll();
		var categoriaDto = categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
		return ResponseEntity.ok().body(categoriaDto);
	}

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        var categoria = categoriaService.create(categoria);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);

    }

}
