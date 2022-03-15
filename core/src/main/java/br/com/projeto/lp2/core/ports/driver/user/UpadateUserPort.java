package br.com.projeto.lp2.core.ports.driver.user;

import br.com.projeto.lp2.core.domain.User;


public interface UpadateUserPort {
    User apply(String id, User user);
}
