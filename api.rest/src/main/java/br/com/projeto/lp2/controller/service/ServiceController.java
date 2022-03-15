package br.com.projeto.lp2.controller.service;

import br.com.projeto.lp2.controller.service.request.ServiceRequest;
import br.com.projeto.lp2.controller.service.response.ServiceResponse;
import br.com.projeto.lp2.core.domain.Service;
import br.com.projeto.lp2.core.ports.driver.service.CreateServicePort;
import br.com.projeto.lp2.core.ports.driver.service.DeleteServiceByIdPort;
import br.com.projeto.lp2.core.ports.driver.service.GetServiceByIdPort;
import br.com.projeto.lp2.core.ports.driver.service.UpdateServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("services")
public record ServiceController(
        CreateServicePort createServicePort,
        GetServiceByIdPort getServiceByIdPort,
        UpdateServicePort  updateServicePort,
        DeleteServiceByIdPort deleteServiceByIdPort

) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceResponse post(@RequestBody @Valid  ServiceRequest request) {
        var service = request.toService();
        var serviceSaved = createServicePort.apply(service);
        return new ServiceResponse().fromService(serviceSaved);
    }

    @GetMapping("{id}")
    public ServiceResponse getUserById(@PathVariable String id) {
        Service service = getServiceByIdPort.apply(id);
        return new ServiceResponse().fromService(service);
    }

    @PutMapping("{id}")
    public ServiceResponse updateUser(@PathVariable String id, @RequestBody ServiceRequest request) {
        Service service = request.toService();
        Service serviceUpdated = updateServicePort.apply(id, service);
        return new ServiceResponse().fromService(serviceUpdated);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id) {
        deleteServiceByIdPort.apply(id);
    }
}
