package no.ensurance.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.ensurance.api.model.*;
import java.util.UUID;

@RestController

public class ContractController {


    @PostMapping("/createcustomer")
    public Mono<Contract> createCustomer(@RequestBody Contract contract) {
        Contract response = duplicateContract(contract);

        String uuid = UUID.randomUUID().toString();
        // Generate a random UUID
        response.setCustomerNumber(uuid);

        response.setContractStatus(Status.STATUS.CUSTOMER_CREATED.name());
        System.out.println("customer number: " + uuid);
        System.out.println(contract.toString());
        return Mono.just(response);
    }

    @PostMapping("/createcontract")
    public Mono<Contract> createContract(@RequestBody Contract contract) {
        Contract response = duplicateContract(contract);

        String uuid = UUID.randomUUID().toString();
        // Generate a random UUID
        response.setContractNumber(uuid);

        response.setContractStatus(Status.STATUS.CONTRACT_CREATED.name());
        System.out.println("contract number: " + uuid);
        return Mono.just(response);
    }
    
    @PostMapping("/activatecontract")
    public Mono<Contract> activateContract(@RequestBody Contract contract) {

        Contract response = duplicateContract(contract);

        String uuid = UUID.randomUUID().toString();
        // Generate a random UUID
        response.setContractNumber(uuid);

        response.setContractStatus(Status.STATUS.CONTRACT_SEND.name());
        System.out.println("contract number: " + uuid);
        return Mono.just(response);
    }

    private Contract duplicateContract(Contract contract) {
        Contract r10 = new Contract();
        r10.setContractNumber(contract.getContractNumber());
        r10.setContractStatus(contract.getContractStatus());
        r10.setCustomer(contract.getCustomer());
        r10.setCustomerNumber(contract.getCustomerNumber());

        return r10;
    }
    
}