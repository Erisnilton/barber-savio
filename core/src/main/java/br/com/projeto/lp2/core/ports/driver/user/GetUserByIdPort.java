package br.com.projeto.lp2.core.ports.driver.user;

import br.com.projeto.lp2.core.domain.User;

import java.util.Optional;

public interface GetUserByIdPort {
    User apply(String id);
}
