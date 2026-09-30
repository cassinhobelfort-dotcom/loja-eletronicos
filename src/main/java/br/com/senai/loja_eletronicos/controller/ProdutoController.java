package br.com.senai.loja_eletronicos.controller;

import br.com.senai.loja_eletronicos.model.Produto;
import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ProdutoController {

    // 1. Injetar o repositório no Controller
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/catalogo")
    public String mostrarCatalogo(Model model) {
        // 2. Ir à base de dados buscar todos os produtos guardados
        List<Produto> listaDeProdutos = produtoRepository.findAll();
        
        // 3. Colocar a lista dentro do 'Model' para enviá-la para o HTML
        model.addAttribute("produtos", listaDeProdutos);
        
        // 4. Retornar a página HTML
        return "catalogo"; 
    }
}