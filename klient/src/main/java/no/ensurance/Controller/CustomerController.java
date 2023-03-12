package no.ensurance.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import no.ensurance.client.IntegrationLayerClient;
import no.ensurance.model.*;

@RestController
@RequestMapping("customer")
public class CustomerController {



    // @Autowired
    // IntegrationLayerClient client;
    @PostMapping
    public Mono<Contract> createContract(@RequestBody Customer customerMono){
        //System.out.println(customerMono.toString());
        Contract contract = new Contract();
        contract.setCustomer(customerMono);
        contract.setContractNumber("xxxxx");
        contract.setContractStatus("created");
        return Mono.just(contract);
    }
}