package com.ibtihadj.fedapay.fedapay.playloads.requests;

import com.ibtihadj.fedapay.fedapay.models.Currency;
import com.ibtihadj.fedapay.fedapay.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionRequest {
    private String description;
    private int amount;
    private Currency currency;
    private String callback_url;
    private Customer customer;
}
