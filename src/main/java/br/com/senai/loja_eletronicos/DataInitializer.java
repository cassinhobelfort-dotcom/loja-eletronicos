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
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new Produto("Smartphone Galaxy A54 5G", "Tela Super AMOLED 6.4\", 128GB de armazenamento, câmera tripla de 50MP e resistência à água IP67.", 1799.00, 15, "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Smartphone Motorola Moto G86", "Smartphone Android com tela de 120Hz, processador octa-core e bateria de longa duração com carregamento rápido.", 1499.00, 20, "https://images.unsplash.com/photo-1598327105666-5b89351aff97?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Monitor Gamer 27\" Full HD", "Painel IPS com taxa de atualização de 165Hz, tempo de resposta de 1ms e suporte a FreeSync.", 1299.90, 8, "https://images.unsplash.com/photo-1527443224154-c4a3942d3acf?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Teclado Mecânico RGB", "Teclado mecânico para jogos com switches azuis, iluminação RGB personalizável e anti-ghosting total.", 349.90, 25, "https://images.unsplash.com/photo-1587829741301-dc798b83add3?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Roteador Wi-Fi 6 Dual Band", "Equipamento dual-band de alta velocidade, ideal para otimização de latência e múltiplos dispositivos.", 280.00, 12, "https://images.unsplash.com/photo-1544197150-b99a580bb7a8?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Fone de Ouvido Bluetooth Noise Cancelling", "Fones de ouvido sem fio com cancelamento ativo de ruído (ANC), até 30h de autonomia e microfone HD.", 450.00, 18, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Smartwatch Fitness Pro", "Relógio inteligente com monitoramento cardíaco, GPS integrado, medição de SpO2 e resistente à água 5ATM.", 599.00, 30, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Carregador Rápido GaN 65W", "Carregador de parede ultracompacto com 2 portas USB-C e 1 USB-A, compatível com computadores e smartphones.", 189.90, 40, "https://images.unsplash.com/photo-1583863788434-e58a36330cf0?auto=format&fit=crop&w=500&q=80"),
                    new Produto("Cadeira Gamer Ergonômica", "Cadeira para jogos com ajuste de altura, apoio de braços 3D e reclinação até 180 graus com estofamento em couro sintético.", 899.00, 5, "https://images.unsplash.com/photo-1598550476439-6847785fcea6?auto=format&fit=crop&w=500&q=80"),
                    new Produto("SSD NVMe M.2 1TB", "Unidade de estado sólido PCIe 4.0 com velocidades de leitura até 5000MB/s e escrita de 4400MB/s.", 420.00, 22, "https://images.unsplash.com/photo-1597872200969-2b65d56bd16b?auto=format&fit=crop&w=500&q=80")
                ));
            }
        };
    }
}