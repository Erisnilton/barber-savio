package br.com.projeto.lp2.core.ports.driven.repository.service;

import br.com.projeto.lp2.core.domain.Service;

import java.util.Optional;

public interface ServiceRepositoryPort {
    Service save(Service service);

    Optional<Service> findById(String id);

    void deleteById(String id);
}
