package br.com.senai.loja_eletronicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.loja_eletronicos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}