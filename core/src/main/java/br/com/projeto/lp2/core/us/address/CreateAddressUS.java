package br.com.projeto.lp2.core.us.address;

import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.ports.driven.repository.address.AddressRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.addresss.CreateAdressPort;
import org.springframework.stereotype.Service;

@Service
public record CreateAddressUS(AddressRepositoryPort repository) implements CreateAdressPort {
    @Override
    public Address apply(Address address) {
        return repository.save(address);
    }
}
