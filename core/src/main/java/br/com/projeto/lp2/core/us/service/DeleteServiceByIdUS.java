package br.com.projeto.lp2.core.us.service;

import br.com.projeto.lp2.core.ports.driven.repository.service.ServiceRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.service.DeleteServiceByIdPort;
import org.springframework.stereotype.Service;

@Service
public record DeleteServiceByIdUS(ServiceRepositoryPort repository) implements DeleteServiceByIdPort {
    @Override
    public void apply(String id) {
        repository.deleteById(id);

    }
}
