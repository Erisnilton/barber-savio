package br.com.projeto.lp2.core.us.user;

import br.com.projeto.lp2.core.domain.User;
import br.com.projeto.lp2.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.user.GetAllUsersPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record GetAllUsers(UserRepositoryPort repository) implements GetAllUsersPort {
    @Override
    public List<User> apply() {
        return repository.findAll();
    }
}
