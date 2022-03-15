package br.com.projeto.lp2.core.ports.driver.addresss;

import br.com.projeto.lp2.core.domain.Address;

public interface UpdateAddressPort {
    Address apply(Address address, String id);
}
