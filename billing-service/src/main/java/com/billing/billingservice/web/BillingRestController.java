package com.billing.billingservice.web;

import com.billing.billingservice.entities.Bill;
import com.billing.billingservice.feignclients.CustomerRestClient;
import com.billing.billingservice.feignclients.ProductItemRestClient;
import com.billing.billingservice.models.Customer;
import com.billing.billingservice.models.Product;
import com.billing.billingservice.repositories.BillRepository;
import com.billing.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController

public class BillingRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private ProductItemRestClient productItemRestClient;
    private CustomerRestClient customerRestClient;

    public BillingRestController(BillRepository billRepository,
                                 ProductItemRepository productItemRepository,
                                 ProductItemRestClient productItemRestClient,
                                 CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.productItemRestClient = productItemRestClient;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bill.getCustomerID());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(productItem -> {
            Product product = productItemRestClient.findProductById(productItem.getProductID());
            productItem.setProduct(product);
            productItem.setProductName(product.getName());
        });

        return bill;
    }
    @GetMapping(path="/customerBills/{customerId}")
    public Collection<Bill> getBillByCustomerId(@PathVariable Long customerId){
        Collection<Bill> bills=billRepository.findBillsByCustomerID(customerId);
        return bills;
    }
}