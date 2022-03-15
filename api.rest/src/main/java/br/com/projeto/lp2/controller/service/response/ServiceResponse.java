package br.com.projeto.lp2.controller.service.response;

import br.com.projeto.lp2.core.domain.Service;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ServiceResponse {
    private  String id;
    private String name;
    private BigDecimal price;
    private BigDecimal duration;


    public ServiceResponse fromService(Service service) {

        this.id = service.getId();
        this.name = service.getName();
        this.price = service.getPrice();
        this.duration = service.getDuration();
        return this;
    }
}
