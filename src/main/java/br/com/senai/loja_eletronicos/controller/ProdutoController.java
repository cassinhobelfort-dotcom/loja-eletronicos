package br.com.senai.loja_eletronicos.controller;

import br.com.senai.loja_eletronicos.model.Produto;
import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Listar catálogo
    @GetMapping("/catalogo")
    public String listarCatalogo(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        model.addAttribute("novoProduto", new Produto());
        return "catalogo";
    }

    // Salvar ou Atualizar produto
    @PostMapping("/produtos/salvar")
    public String salvarProduto(@ModelAttribute("novoProduto") Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/catalogo";
    }

    // Excluir produto
    @GetMapping("/produtos/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/catalogo";
    }

    // Carregar dados para edição
    @GetMapping("/produtos/editar/{id}")
    public String carregarParaEditar(@PathVariable("id") Long id, Model model) {
        Produto produtoParaEditar = produtoRepository.findById(id).orElse(new Produto());
        model.addAttribute("novoProduto", produtoParaEditar);
        model.addAttribute("produtos", produtoRepository.findAll());
        return "catalogo";
    }
}