package no.ensurance.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Setter
    @Getter
    private String customerName;

    @Setter
    @Getter
    private String customerAddress;

    @Setter
    @Getter
    private String customerPhoneNumber;


    public String getName() {
        return customerName;
    }
}
