package br.com.projeto.lp2.core.us.address;

import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.ports.driven.repository.address.AddressRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.addresss.GetAddressByIdPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record GetAddressByIdUS(AddressRepositoryPort repository) implements GetAddressByIdPort {
    @Override
    public Address apply(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possivel encontrar o endereço."));
    }
}
