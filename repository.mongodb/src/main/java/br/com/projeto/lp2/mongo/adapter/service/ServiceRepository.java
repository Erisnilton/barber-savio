package br.com.projeto.lp2.mongo.adapter.service;

import br.com.projeto.lp2.core.domain.Service;
import br.com.projeto.lp2.core.ports.driven.repository.service.ServiceRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceRepository extends MongoRepository<Service, String>, ServiceRepositoryPort {
}
