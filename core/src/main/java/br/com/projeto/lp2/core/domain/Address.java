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
public class Address {
    private String id;
    private String street;
    private String district;
    private Integer number;
    private String city;
}
