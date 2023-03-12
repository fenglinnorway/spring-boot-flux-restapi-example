package no.ensurance.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.ensurance.config.Configuration;

import no.ensurance.api.model.*;

@Component
public class FagsystemClient {


    
    private WebClient webClient;
    private ObjectMapper objectMapper;
    @Autowired
    public FagsystemClient(Configuration config) {
        this.webClient = WebClient.create(config.getIntegrationUrl());
        this.objectMapper = new ObjectMapper();
    }
    

    public Mono<Contract> createCustomer(Contract contract) {
        return webClient.post()
                .uri("/createcustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(contract))
                .retrieve()
                .bodyToMono(String.class)
                .map(responseString -> {
                    try {
                        return objectMapper.readValue(responseString, Contract.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse JSON response", e);
                    }
                });
    }


    public Mono<Contract> createContract(Contract contract) {
        return webClient.post()
                .uri("/createcontract")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(contract))
                .retrieve()
                .bodyToMono(String.class)
                .map(responseString -> {
                    try {
                        return objectMapper.readValue(responseString, Contract.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse JSON response", e);
                    }
                });
    }



    public Mono<Contract> updateStatus(Contract contract) {
        return webClient.post()
                .uri("/activatecontract")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(contract))
                .retrieve()
                .bodyToMono(String.class)
                .map(responseString -> {
                    try {
                        return objectMapper.readValue(responseString, Contract.class);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse JSON response", e);
                    }
                });
    }

}