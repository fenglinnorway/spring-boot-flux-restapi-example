package no.ensurance.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Contract {
    private String contractNumber;
    private String contractStatus;

    @Setter
    @Getter
    private Customer customer;

    public Contract(String contractNumber, Customer customer) {
        this.contractNumber = contractNumber;
        this.customer = customer;
    }
}
