package br.com.projeto.lp2.controller.user.response;

import br.com.projeto.lp2.controller.address.response.AddressResponse;
import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.domain.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String phone;
    private AddressResponse address;

    public UserResponse fromUser(User user) {

        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = getAddressResponse(user);
        return this;
    }

    private AddressResponse getAddressResponse(User user) {
        return new AddressResponse().fromAddrress(user.getAddress());
    }
}
