package br.com.projeto.lp2.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private  String id;
    private String name;
    private BigDecimal price;
    private BigDecimal duration;
}
