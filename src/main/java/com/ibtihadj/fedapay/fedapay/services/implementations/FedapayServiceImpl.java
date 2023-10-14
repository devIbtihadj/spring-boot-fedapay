package com.ibtihadj.fedapay.fedapay.services.implementations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibtihadj.fedapay.fedapay.constants.Urls;
import com.ibtihadj.fedapay.fedapay.playloads.requests.TransactionRequest;
import com.ibtihadj.fedapay.fedapay.playloads.responses.TokenAndTransactionPaymentLinkResponse;
import com.ibtihadj.fedapay.fedapay.playloads.responses.TransactionResponse;
import com.ibtihadj.fedapay.fedapay.services.statments.FedapayService;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class FedapayServiceImpl implements FedapayService {


    @Value("${fedapay.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public FedapayServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void createTransaction(TransactionRequest transactionRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TransactionRequest> request = new HttpEntity<>(transactionRequest, headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                Urls.SANDBOX_ACCOUNT_API_BASE_URL,
                HttpMethod.POST,
                request,
                JsonNode.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonNode responseBody = response.getBody();

            // Vérifiez si le champ "v1/transaction" existe dans la réponse JSON
            assert responseBody != null;
            if (responseBody.has("v1/transaction")) {
                // Récupérez le nœud JSON correspondant à "v1/transaction"
                JsonNode transactionNode = responseBody.get("v1/transaction");

                // Convertissez le nœud JSON en une instance de TransactionResponse
                ObjectMapper objectMapper = new ObjectMapper();
                TransactionResponse transactionResponse = objectMapper.convertValue(transactionNode, TransactionResponse.class);

                generateTokenAndTransactionPaymentLink(transactionResponse.getId());
                System.out.println("Transaction created successfully.");
                System.out.println("Transaction Response: " + transactionResponse);
            } else {
                System.err.println("Error: 'v1/transaction' not found in the response.");
            }
        } else {
            System.err.println("Error creating transaction: " + response.getBody());
        }
    }

    @Override
    public void generateTokenAndTransactionPaymentLink(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TransactionRequest> request = new HttpEntity<>(headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(
                Urls.SANDBOX_ACCOUNT_API_BASE_URL+"/"+id+"/token",
                HttpMethod.POST,
                request,
                JsonNode.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            JsonNode responseBody = response.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            TokenAndTransactionPaymentLinkResponse tokenAndTransactionPaymentLinkResponse = objectMapper.convertValue(responseBody, TokenAndTransactionPaymentLinkResponse.class);

            System.out.println(tokenAndTransactionPaymentLinkResponse.toString());
        } else {
            System.err.println("Error creating transaction: " + response.getBody());
        }
    }

    @Override
    public void getTransactionDetails(long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TransactionRequest> request = new HttpEntity<>(headers);

        System.out.println("+++++++++++id "+id);
        ResponseEntity<JsonNode> response = restTemplate.exchange(
                Urls.SANDBOX_ACCOUNT_API_BASE_URL+"/"+id,
                HttpMethod.GET,
                request,
                JsonNode.class
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            JsonNode responseBody = response.getBody();

            // Vérifiez si le champ "v1/transaction" existe dans la réponse JSON
            assert responseBody != null;
            if (responseBody.has("v1/transaction")) {
                // Récupérez le nœud JSON correspondant à "v1/transaction"
                JsonNode transactionNode = responseBody.get("v1/transaction");

                // Convertissez le nœud JSON en une instance de TransactionResponse
                ObjectMapper objectMapper = new ObjectMapper();
                TransactionResponse transactionResponse = objectMapper.convertValue(transactionNode, TransactionResponse.class);

                generateTokenAndTransactionPaymentLink(transactionResponse.getId());
                System.out.println("Transaction created successfully.");
                System.out.println("Transaction Response: " + transactionResponse);
            } else {
                System.err.println("Error: 'v1/transaction' not found in the response.");
            }
        } else {
            System.err.println("Error creating transaction: " + response.getBody());
        }
    }


}
