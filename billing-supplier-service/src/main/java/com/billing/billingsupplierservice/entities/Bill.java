package com.billing.billingsupplierservice.entities;


import com.billing.billingsupplierservice.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {

    private Long id;
    private BillStatus status;
    private Date billingDate;
    private Long customerID;
    private Collection<ProductItem> productItems;

}

