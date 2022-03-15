package br.com.projeto.lp2.mongo.adapter.user;

import br.com.projeto.lp2.core.domain.User;
import br.com.projeto.lp2.core.ports.driven.repository.user.UserRepositoryPort;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> , UserRepositoryPort{
}
