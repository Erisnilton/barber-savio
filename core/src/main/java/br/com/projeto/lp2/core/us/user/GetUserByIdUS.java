package br.com.projeto.lp2.core.us.user;

import br.com.projeto.lp2.core.domain.User;
import br.com.projeto.lp2.core.ports.driven.repository.user.UserRepositoryPort;
import br.com.projeto.lp2.core.ports.driver.user.GetUserByIdPort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public record GetUserByIdUS(UserRepositoryPort repo ) implements GetUserByIdPort {
    @Override
    public User apply(String id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));
    }
}
