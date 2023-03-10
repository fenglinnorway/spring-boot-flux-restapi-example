package no.ensurance.router;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;


import no.ensurance.model.*;

@RestController
public class ContractController {

    @PostMapping(value = "/createContract")
    public Mono<Contract> createContract(@RequestBody Customer requestMono) {
        Contract response = processRequest(requestMono);
        return Mono.just(response);
    }

    private Contract processRequest(Customer request) {

        Contract contract = new Contract();
        contract.setContractNumber(UUID.randomUUID().toString());
        contract.setCustomer(request);
        contract.setContractStatus("created");
        return contract;
    }

}
