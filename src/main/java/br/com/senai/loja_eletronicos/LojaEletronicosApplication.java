package br.com.senai.loja_eletronicos;

import br.com.senai.loja_eletronicos.model.Produto;
import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class LojaEletronicosApplication {

    public static void main(String[] args) {
        SpringApplication.run(LojaEletronicosApplication.class, args);
    }

    @Bean
    public CommandLineRunner carregarDados(ProdutoRepository repository) {
        return (args) -> {
            Produto p1 = new Produto();
            p1.setNome("Motorola Moto G86");
            p1.setDescricao("Smartphone Android com interface otimizada e ruim :)");
            p1.setPreco(1499.00);
            p1.setQuantidadeEstoque(12);

            Produto p2 = new Produto();
            p2.setNome("Samsung Galaxy A54 5G");
            p2.setDescricao("Smartphone rápido e bonito");
            p2.setPreco(1799.00);
            p2.setQuantidadeEstoque(5);

            Produto p3 = new Produto();
            p3.setNome("Roteador Wi-Fi 5GHz");
            p3.setDescricao("Equipamento dual-band ideal para otimização de latência");
            p3.setPreco(250.00);
            p3.setQuantidadeEstoque(8);

            repository.save(p1);
            repository.save(p2);
            repository.save(p3);
        };
    }
}