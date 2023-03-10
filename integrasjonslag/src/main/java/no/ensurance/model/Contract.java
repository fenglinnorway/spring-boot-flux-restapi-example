package no.ensurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private String contractNumber;
    
    @Getter
    @Setter
    private String contractStatus;

    @Setter
    @Getter
    private Customer customer;

    public Contract (String contractNumber, Customer customer, String contractStatus) {
        this.contractNumber = contractNumber;
        this.customer = customer;
        this.contractStatus = contractStatus;
    }
}
