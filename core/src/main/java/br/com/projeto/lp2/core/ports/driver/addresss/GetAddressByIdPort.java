package br.com.projeto.lp2.core.ports.driver.addresss;

import br.com.projeto.lp2.core.domain.Address;

import java.util.Optional;

public interface GetAddressByIdPort {
    Address apply(String id);
}
