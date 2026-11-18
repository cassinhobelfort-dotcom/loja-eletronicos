package br.com.senai.loja_eletronicos.controller;

import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@WebMvcTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Criamos um mock do repositório/serviço para que o controlador não falhe ao tentar injetá-lo
    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    public void deveRetornarSucessoAoAcessarPaginaDeCatalogo() throws Exception {
        // Simulamos que a base de dados retorna uma lista vazia quando o controller chamar o findAll
        when(produtoRepository.findAll()).thenReturn(Collections.emptyList());

        // Simula uma requisição GET para a rota do catálogo e verifica se o status HTTP é 200 OK
        mockMvc.perform(get("/catalogo"))
                .andExpect(status().isOk());
    }
}