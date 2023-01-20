package com.billing.billingservice.service;

import com.billing.billingservice.entities.Bill;
import com.billing.billingservice.entities.ProductItem;
import com.billing.billingservice.feignclients.ProductItemRestClient;
import com.billing.billingservice.models.Product;
import com.billing.billingservice.repositories.BillRepository;
import com.billing.billingservice.repositories.ProductItemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Service
public class BillService {

    public BillService(BillRepository billRepository,ProductItemRepository productItemRepository) {
        this.billRepository = billRepository;
        this.productItemRepository= productItemRepository;
    }

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    @Bean
    public Consumer<Bill> billsConsumer(){
        return (input)->{
            input.getProductItems().forEach(productItem -> {
                productItemRepository.save(productItem);
            });
            billRepository.save(input);
            System.out.println(input.toString());
            System.out.println("***************");
        };
    }
}
