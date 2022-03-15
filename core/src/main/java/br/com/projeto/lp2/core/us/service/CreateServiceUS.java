package br.com.projeto.lp2.core.us.service;

import br.com.projeto.lp2.core.domain.Service;
import br.com.projeto.lp2.core.ports.driven.repository.service.ServiceRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.service.CreateServicePort;


@org.springframework.stereotype.Service
record CreateServiceUS(ServiceRepositoryPort repository) implements CreateServicePort {
    @Override
    public Service apply(Service service) {
        return repository.save(service);
    }
}
