package br.com.projeto.lp2.controller.user.request;

import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserRequest {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String phone;
    private Address address;
    @NotBlank
    private String password;

    public User toUser() {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setPassword(password);
        return  user;
    }
}
