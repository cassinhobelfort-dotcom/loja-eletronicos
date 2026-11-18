package br.com.senai.loja_eletronicos.repository;

import br.com.senai.loja_eletronicos.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    public void deveSalvarEBuscarProdutoComSucesso() {
        // Cenário: Criar um novo produto
        Produto produto = new Produto(
            "Smartphone Teste", 
            "Tela de teste", 
            999.00, 
            10, 
            "https://via.placeholder.com/150"
        );

        // Ação: Salvar no banco de dados (H2 em memória)
        Produto produtoSalvo = produtoRepository.save(produto);

        // Verificação: Garantir que o ID foi gerado e os dados batem
        assertThat(produtoSalvo).isNotNull();
        assertThat(produtoSalvo.getId()).isNotNull();
        assertThat(produtoSalvo.getNome()).isEqualTo("Smartphone Teste");
    }
}