package br.com.projeto.lp2.controller.address.response;

import br.com.projeto.lp2.core.domain.Address;
import lombok.Getter;

@Getter
public class AddressResponse {
    private String id;
    private String street;
    private String district;
    private Integer number;
    private String city;

    public AddressResponse fromAddrress(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.district = address.getDistrict();
        this.number = address.getNumber();
        this.city = address.getCity();
        return this;
    }
}
