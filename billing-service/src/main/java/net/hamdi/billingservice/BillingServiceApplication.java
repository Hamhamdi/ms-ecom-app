package net.hamdi.billingservice;

import net.hamdi.billingservice.entities.Bill;
import net.hamdi.billingservice.entities.ProductItem;
import net.hamdi.billingservice.feign.CustomerRestclient;
import net.hamdi.billingservice.feign.ProductRestClient;
import net.hamdi.billingservice.model.Customer;
import net.hamdi.billingservice.model.Product;
import net.hamdi.billingservice.repository.BillRepository;
import net.hamdi.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository,
										ProductItemRepository productItemRepository,
										CustomerRestclient customerRestclient,
										ProductRestClient productRestClient
	){

	 	return args -> {
			Collection <Customer> customers = customerRestclient.getAllCustomer().getContent();
			Collection<Product> products = productRestClient.getAllProducts().getContent();

			customers.forEach(customer -> {
				Bill bill = Bill.builder()
						.billingDate(new Date())
						.customerId(customer.getId())
						.build();
				billRepository.save(bill);
				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.bill(bill)
							.quantity(1+new Random().nextInt(10))
							.productId(product.getId())
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});
			});
		};

	}
}
