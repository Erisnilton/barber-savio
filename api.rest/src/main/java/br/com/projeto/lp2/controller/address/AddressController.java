package br.com.projeto.lp2.controller.address;

import br.com.projeto.lp2.controller.address.request.AddressRequest;
import br.com.projeto.lp2.controller.address.response.AddressResponse;
import br.com.projeto.lp2.core.domain.Address;
import br.com.projeto.lp2.core.ports.driver.addresss.CreateAdressPort;
import br.com.projeto.lp2.core.ports.driver.addresss.DeleteAddressPort;
import br.com.projeto.lp2.core.ports.driver.addresss.GetAddressByIdPort;
import br.com.projeto.lp2.core.ports.driver.addresss.UpdateAddressPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("address")
public record AddressController(
        CreateAdressPort createAdressPort,
        GetAddressByIdPort getAddressByIdPort,
        UpdateAddressPort updateAddressPort,
        DeleteAddressPort deleteAddressPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressResponse post(@RequestBody @Valid AddressRequest request){
        var address = request.toAddress();
        Address addressSaved = createAdressPort.apply(address);
        return new AddressResponse().fromAddrress(addressSaved);
    }

    @GetMapping("{id}")
    public AddressResponse getAddressById(@PathVariable String id) {
        var address = getAddressByIdPort.apply(id);
        return new AddressResponse().fromAddrress(address);
    }

    @PutMapping("{id}")
    public AddressResponse updateAddress(@RequestBody @Valid AddressRequest request, @PathVariable String id) {
        var address = request.toAddress();
        return  new AddressResponse().fromAddrress(updateAddressPort.apply(address, id));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddressByid(@PathVariable String id) {
        deleteAddressPort.apply(id);
    }
}
