package xyz.hemoreg.demopostgresql.usermanagment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hemoreg.demopostgresql.usermanagment.dto.ClientDTO;
import xyz.hemoreg.demopostgresql.usermanagment.service.ClientService;

import java.util.List;

@RestController()
@RequestMapping(path = "/clients")
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> getClients() {
        return clientService.getClients();
    }

    @GetMapping(path= "/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }
}
