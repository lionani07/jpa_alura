package app.controller;

import app.model.Produto;
import app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        final var produtoSaved = this.produtoRepository.save(produto);
        final var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoSaved.getId())
                .toUri();
        return ResponseEntity.created(location).body(produtoSaved);
    }

    @GetMapping
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @GetMapping(params = "categoria")
    public List<Produto> findByCategoria(@RequestParam String categoria) {
        return produtoRepository.findAllByCategoriaNome(categoria);
    }
}
