package br.com.senai.loja_eletronicos.controller;

import br.com.senai.loja_eletronicos.model.Produto;
import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoRestController {

    @Autowired
    private ProdutoRepository repository;

    // GET: Listar todos os registros
    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    // GET: Buscar um registro específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Erro 404
    }

    // POST: Criação de novos registros
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produto) {
        Produto novoProduto = repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto); // Status 201
    }

    // PUT: Atualização de registros existentes
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        produtoAtualizado.setId(id); // Garante que vai atualizar o ID correto
        Produto produtoSalvo = repository.save(produtoAtualizado);
        return ResponseEntity.ok(produtoSalvo); // Status 200
    }

    // DELETE: Exclusão de registros
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // Status 204
    }
}