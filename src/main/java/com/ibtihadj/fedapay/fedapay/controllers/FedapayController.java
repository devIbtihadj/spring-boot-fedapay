package com.ibtihadj.fedapay.fedapay.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibtihadj.fedapay.fedapay.models.Currency;
import com.ibtihadj.fedapay.fedapay.models.Customer;
import com.ibtihadj.fedapay.fedapay.models.PhoneNumber;
import com.ibtihadj.fedapay.fedapay.playloads.requests.TransactionRequest;
import com.ibtihadj.fedapay.fedapay.services.statments.FedapayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class FedapayController {
    private static final String CONTROLLER_NAME = "fedapay";

    private final FedapayService fedapayService;


    @Autowired
    public FedapayController(FedapayService fedapayService) {
        this.fedapayService = fedapayService;
    }

    @GetMapping(value = CONTROLLER_NAME+"/create", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> creerAnnee() throws JsonProcessingException {
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount(100);
        transactionRequest.setCurrency(new Currency("XOF"));
        transactionRequest.setCustomer(new Customer("Ibtihadj", "KPEKPASSI", "ibtihadjpro@gmail.com", new PhoneNumber("+22893899766", "tg")));
        transactionRequest.setDescription("Test");
        fedapayService.createTransaction(transactionRequest);
        return ResponseEntity.status(CREATED).body("---");
    }


    @GetMapping(value = CONTROLLER_NAME+"/details", produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<String> details(){
        fedapayService.getTransactionDetails(214678 );
        return ResponseEntity.status(CREATED).body("---");
    }








}
