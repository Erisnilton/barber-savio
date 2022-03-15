package br.com.projeto.lp2.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private String password;
}
