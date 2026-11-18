package br.com.senai.loja_eletronicos.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoTest {

    @Test
    public void deveCriarProdutoComConstrutorEAtributosCorretos() {
        // Cenário e Ação: Instanciar um produto usando o construtor com parâmetros
        Produto produto = new Produto(
            "Smartphone XYZ", 
            "128GB, 8GB RAM", 
            1500.00, 
            5, 
            "https://exemplo.com/imagem.png"
        );

        // Verificação: Garantir que os valores atribuídos estão corretos
        assertThat(produto.getNome()).isEqualTo("Smartphone XYZ");
        assertThat(produto.getDescricao()).isEqualTo("128GB, 8GB RAM");
        assertThat(produto.getPreco()).isEqualTo(1500.00);
        assertThat(produto.getQuantidadeEstoque()).isEqualTo(5);
        assertThat(produto.getImagemUrl()).isEqualTo("https://exemplo.com/imagem.png");
    }
}