package br.com.projeto.lp2.core.us.user;

import br.com.projeto.lp2.core.domain.User;
import br.com.projeto.lp2.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.user.UpadateUserPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record UpdateUserUS(UserRepositoryPort repository) implements UpadateUserPort {
    @Override
    public User apply(String id, User user) {

        Optional<User> userForUpdate = repository.findById(id);
        return userForUpdate.map(userUpdating -> {
            userUpdating.setName(user.getName());
            userUpdating.setEmail(user.getEmail());
            userUpdating.setPhone(user.getPhone());
            userUpdating.setAddress(user.getAddress());
            return repository.save(userUpdating);
        }).orElseThrow(() -> new IllegalArgumentException("Não foi possivel utualizar o usuário."));
    }
}
