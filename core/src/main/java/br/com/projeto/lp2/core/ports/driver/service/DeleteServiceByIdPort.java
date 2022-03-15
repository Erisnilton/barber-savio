package br.com.projeto.lp2.core.ports.driver.service;

import java.util.Optional;

public interface DeleteServiceByIdPort {
    void apply(String id);
}
