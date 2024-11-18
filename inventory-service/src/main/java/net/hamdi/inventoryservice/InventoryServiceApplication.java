package net.hamdi.inventoryservice;

import net.hamdi.inventoryservice.entities.Product;
import net.hamdi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString()).name("Computer").quantity(10).price(32000).build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString()).name("Printer").quantity(100).price(2000).build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString()).name("smart Phone").quantity(140).price(12000).build());

            productRepository.findAll().forEach(p -> {
                System.out.println(p.toString());
            });

        };
    }

}
