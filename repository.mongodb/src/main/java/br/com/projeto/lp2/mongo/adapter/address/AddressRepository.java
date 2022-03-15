package br.com.projeto.lp2.mongo.adapter.address;

import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.ports.driven.repository.address.AddressRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, Long>, AddressRepositoryPort {
}
