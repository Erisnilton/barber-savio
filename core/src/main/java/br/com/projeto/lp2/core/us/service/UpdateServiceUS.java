package br.com.projeto.lp2.core.us.service;

import br.com.projeto.lp2.core.domain.Service;
import br.com.projeto.lp2.core.ports.driven.repository.service.ServiceRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.service.UpdateServicePort;

import java.util.Optional;

@org.springframework.stereotype.Service
public record UpdateServiceUS(ServiceRepositoryPort repository) implements UpdateServicePort {
    @Override
    public Service apply(String id, Service service) {
        Optional<Service> serviceOptional = repository.findById(id);
        return serviceOptional.map((serviceUpdating) -> {
            serviceUpdating.setName(service.getName());
            serviceUpdating.setPrice(service.getPrice());
            serviceUpdating.setDuration(service.getDuration());
            return repository.save(serviceUpdating);
        }).orElseThrow(() -> new IllegalArgumentException("Não foi possivél atualizar o serviço"));
    }
}
