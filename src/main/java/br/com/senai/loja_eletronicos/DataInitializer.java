package br.com.senai.loja_eletronicos;

import br.com.senai.loja_eletronicos.model.Produto;
import br.com.senai.loja_eletronicos.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ProdutoRepository repository) {
        return args -> {
            // Insere os dados apenas se a tabela estiver vazia para evitar duplicados
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new Produto("Smartphone Galaxy A54 5G", "Tela Super AMOLED 6.4\", 128GB de armazenamento, câmera tripla de 50MP e resistência à água IP67.", 1799.00, 15),
                    new Produto("Motorola Moto G86", "Smartphone Android com tela de 120Hz, processador octa-core e bateria de longa duração com carregamento rápido.", 1499.00, 20),
                    new Produto("Monitor Gamer 27\" Full HD", "Painel IPS com taxa de atualização de 165Hz, tempo de resposta de 1ms e suporte a FreeSync.", 1299.90, 8),
                    new Produto("Teclado Mecânico RGB", "Teclado mecânico para jogos com switches azuis, iluminação RGB personalizável e anti-ghosting total.", 349.90, 25),
                    new Produto("Roteador Wi-Fi 6 Dual Band", "Equipamento dual-band de alta velocidade, ideal para otimização de latência e múltiplos dispositivos.", 280.00, 12),
                    new Produto("Fone de Ouvido Bluetooth Noise Cancelling", "Auriculares sem fios com cancelamento ativo de ruído (ANC), até 30h de autonomia e microfone HD.", 450.00, 18),
                    new Produto("Smartwatch Fitness Pro", "Relógio inteligente com monitoramento cardíaco, GPS integrado, medição de SpO2 e resistente à água 5ATM.", 599.00, 30),
                    new Produto("Carregador Rápido GaN 65W", "Carregador de parede ultra compacto com 2 portas USB-C e 1 USB-A, compatível com computadores e smartphone.", 189.90, 40),
                    new Produto("Cadeira Gamer Ergonómica", "Cadeira para jogos com ajuste de altura, apoio de braços 3D e reclinação até 180 graus com estofamento em pele sintética.", 899.00, 5),
                    new Produto("SSD NVMe M.2 1TB", "Unidade de estado sólido PCIe 4.0 com velocidades de leitura até 5000MB/s e escrita de 4400MB/s.", 420.00, 22)
                ));
            }
        };
    }
}