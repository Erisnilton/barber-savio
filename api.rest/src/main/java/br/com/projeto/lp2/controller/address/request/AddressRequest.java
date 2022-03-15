package br.com.projeto.lp2.controller.address.request;

import br.com.projeto.lp2.core.domain.Address;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
public class AddressRequest {
    @NotBlank
    private String street;
    @NotBlank
    private String district;
    @NotNull
    @Positive
    private Integer number;
    @NotBlank
    private String city;

    public Address toAddress() {
        Address address = new Address();
        address.setStreet(street);
        address.setDistrict(district);
        address.setNumber(number);
        address.setCity(city);
        return address;
    }
}
