package no.ensurance.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.ensurance.config.Configuration;

import no.ensurance.api.model.*;


public class IntegrationLayerClient {

    @Autowired
    Configuration config;
    private WebClient webClient;
    private ObjectMapper objectMapper;
    
    public IntegrationLayerClient() {
        this.webClient = WebClient.create(config.getUrl());
        this.objectMapper = new ObjectMapper();
    }
    

    public Mono<Contract> sendCustomer(Customer customer) {
        return webClient.post()
                .uri("/createcontract")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customer))
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
