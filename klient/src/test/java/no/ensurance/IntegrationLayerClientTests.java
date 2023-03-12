package no.ensurance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import no.ensurance.client.IntegrationLayerClient;
import no.ensurance.model.Customer;
import no.ensurance.model.Contract;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.server.WebHandler;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;


@SpringBootTest(classes = TestConfig.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class IntegrationLayerClientTests {

    @LocalServerPort
    private int port;
    @MockBean
    private IntegrationLayerClient client;

    @Autowired
    private WebTestClient webTestClient;



    @Test
    public void testCreateContract() {
        Customer customer = new Customer();
        customer.setCustomerName("John Doe");
        customer.setCustomerAddress("123 Main St");
        customer.setCustomerPhoneNumber("555-1234");
        Contract contract = new Contract();
        contract.setContractNumber("xxxxx");
        contract.setContractStatus("created");
        contract.setCustomer(customer);

        Mockito.when(client.sendCustomer(customer))
        .thenReturn(Mono.just(contract));

        webTestClient.post()
                .uri("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(customer))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Contract.class)
                .isEqualTo(contract);

    }
}
