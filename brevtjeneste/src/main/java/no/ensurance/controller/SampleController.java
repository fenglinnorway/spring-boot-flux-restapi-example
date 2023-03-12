package no.ensurance.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import no.ensurance.api.model.Contract;

@RestController
public class SampleController {


    @PostMapping("/sendmail")
    public Mono<Contract> hello(@RequestBody Contract contract) {


        System.out.println("mail send for contract: " + contract.getContractNumber());
        return Mono.just(contract);


    }

}

