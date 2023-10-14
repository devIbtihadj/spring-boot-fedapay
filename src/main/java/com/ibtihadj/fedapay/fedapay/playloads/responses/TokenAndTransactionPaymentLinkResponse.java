package com.ibtihadj.fedapay.fedapay.playloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TokenAndTransactionPaymentLinkResponse {
    @JsonProperty("token")
    private String token;
    @JsonProperty("url")
    private String url;

    @Override
    public String toString() {
        return "TokenAndTransactionPaymentLinkResponse{" +
                "\n  token='" + token + '\'' +
                "\n  , url='" + url + '\'' +
                "\n  "+
                '}';
    }
}
