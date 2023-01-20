package com.billing.billingsupplierservice.service;


import com.billing.billingsupplierservice.enums.BillStatus;
import com.billing.billingsupplierservice.models.Bill;
import com.billing.billingsupplierservice.models.ProductItem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Service
public class BillsSupplierService {
    @Bean
    public Supplier<Bill> billSupplier(){
        return ()->{
            List<ProductItem> products=new ArrayList<>();
            Bill bill=new Bill();
            bill.setBillingDate(new Date());
            bill.setStatus(Math.random()>0.5? BillStatus.PAID:BillStatus.PENDING);
            bill.setCustomerID(new Random().nextLong((11-1)+1)+1);

            ProductItem productItem=new ProductItem();
            productItem.setBill(bill);

            productItem.setProductID( new Random().nextLong((16-1)+1) + 1);
            productItem.setQuantity(new Random().nextInt(10) + 1);
            productItem.setPrice(Math.round(new Random().nextDouble(1000) + 100));

            ProductItem productItem2=new ProductItem();
            productItem2.setBill(bill);
            productItem2.setProductID( new Random().nextLong((16-1)+1) + 1);
            productItem2.setQuantity(new Random().nextInt(10) + 1);
            productItem2.setPrice(Math.round(new Random().nextDouble(1000) + 100));

            products.add(productItem);
            products.add(productItem2);
            bill.setProductItems(products);

            return bill;
        };
    }
}
