package br.com.projeto.lp2.core.ports.driver.service;

import br.com.projeto.lp2.core.domain.Service;

public interface GetServiceByIdPort {
    Service apply(String id);
}
