package br.com.projeto.lp2.core.ports.driver.addresss;

import br.com.projeto.lp2.core.domain.Address;

public interface CreateAdressPort {
    Address apply(Address address);
}
