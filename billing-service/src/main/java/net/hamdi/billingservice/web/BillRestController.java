package net.hamdi.billingservice.web;

import lombok.AllArgsConstructor;
import net.hamdi.billingservice.entities.Bill;
import net.hamdi.billingservice.feign.CustomerRestclient;
import net.hamdi.billingservice.feign.ProductRestClient;
import net.hamdi.billingservice.repository.BillRepository;
import net.hamdi.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestclient customerRestclient;
    private ProductRestClient productRestClient;

    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        System.out.println("im here");
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestclient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });

        return bill;
    }
}

