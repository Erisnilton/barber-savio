package br.com.projeto.lp2.core.us.address;

import br.com.projeto.lp2.core.ports.driven.repository.address.AddressRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.addresss.DeleteAddressPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteAddressById(AddressRepositoryPort repository) implements DeleteAddressPort {
    @Override
    public void apply(String id) {
        repository.deleteById(id);
    }
}
