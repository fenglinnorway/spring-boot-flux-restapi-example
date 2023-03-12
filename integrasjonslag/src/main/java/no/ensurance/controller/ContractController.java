package no.ensurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


import no.ensurance.api.model.*;
import no.ensurance.client.EmailClient;
import no.ensurance.client.FagsystemClient;

@RestController
public class ContractController {

    @Autowired
    EmailClient emailClient;
    @Autowired
    FagsystemClient fagsystemClient;

    @PostMapping(value = "/createContract")
    public Mono<Contract> createContract(@RequestBody Customer requestMono) {
        return processRequest(requestMono);
    }

    private Mono<Contract> processRequest(Customer request) {

        Contract contract = new Contract();

        contract.setCustomer(request);

        return fagsystemClient.createCustomer(contract);

    }
}
