package com.ibtihadj.fedapay.fedapay.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneNumber {
    private String number;
    private String country;
}
