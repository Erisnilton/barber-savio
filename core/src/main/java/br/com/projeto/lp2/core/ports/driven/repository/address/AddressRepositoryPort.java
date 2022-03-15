package br.com.projeto.lp2.core.ports.driven.repository.address;

import br.com.projeto.lp2.core.domain.Address;

import java.util.Optional;

public interface AddressRepositoryPort {
    Address save(Address address);

    Optional<Address> findById(String id);

    void deleteById(String id);
}
