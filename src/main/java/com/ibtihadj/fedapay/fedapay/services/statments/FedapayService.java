package com.ibtihadj.fedapay.fedapay.services.statments;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibtihadj.fedapay.fedapay.playloads.requests.TransactionRequest;

public interface FedapayService {

    void createTransaction(TransactionRequest transactionRequest) throws JsonProcessingException;
    void generateTokenAndTransactionPaymentLink(long id);
    void getTransactionDetails(long id);

}
