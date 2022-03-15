package br.com.projeto.lp2.controller.service.request;

import br.com.projeto.lp2.core.domain.Service;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
@Setter
public class ServiceRequest {
    @NotBlank
    private String name;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @Positive
    private BigDecimal duration;


    public Service toService() {
        Service service = new Service();
        service.setName(name);
        service.setPrice(price);
        service.setDuration(duration);
        return  service;
    }
}
