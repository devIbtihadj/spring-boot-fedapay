package com.ibtihadj.fedapay.fedapay.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    private String firstname;
    private String lastname;
    private String email;
    private PhoneNumber phoneNumber;
}
