package br.com.boracodardevs.biblioteca.categoria.resources;

import br.com.boracodardevs.biblioteca.domain.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    public ResponseEntity<Categoria> findById(@PathVariable Integer id){

    }

}
