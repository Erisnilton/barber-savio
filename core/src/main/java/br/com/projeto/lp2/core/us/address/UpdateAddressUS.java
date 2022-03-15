package br.com.projeto.lp2.core.us.address;

import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.ports.driven.repository.address.AddressRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.addresss.UpdateAddressPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record UpdateAddressUS(AddressRepositoryPort repository) implements UpdateAddressPort {
    @Override
    public Address apply(Address address, String id) {
        Optional<Address> addressOptional = repository.findById(id);
        return addressOptional.map(addressUpdating -> {
            addressUpdating.setNumber(address.getNumber());
            addressUpdating.setCity(address.getCity());
            addressUpdating.setDistrict(address.getDistrict());
            addressUpdating.setStreet(address.getStreet());
            addressUpdating.setCity(address.getCity());
            return repository.save(addressUpdating);
        }).orElseThrow(() -> new IllegalArgumentException("Não foi possivel atualizar o endereço."));
    }
}
