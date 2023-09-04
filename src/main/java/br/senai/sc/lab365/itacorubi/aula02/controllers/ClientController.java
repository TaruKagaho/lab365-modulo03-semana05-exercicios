package br.senai.sc.lab365.itacorubi.aula02.controllers;

import br.senai.sc.lab365.itacorubi.aula02.dtos.ClientRequest;
import br.senai.sc.lab365.itacorubi.aula02.dtos.ClientResponse;
import br.senai.sc.lab365.itacorubi.aula02.services.ClientService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<String> addNewClient(@RequestBody @Valid ClientRequest newClient) {
        this.clientService.add(newClient);

        return new ResponseEntity<>(
                "Cliente adicionado com sucesso!",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public List<ClientResponse> listClients() {
        return this.clientService.listAllClients();
    }
}
