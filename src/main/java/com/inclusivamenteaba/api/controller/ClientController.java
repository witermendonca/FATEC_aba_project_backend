package com.inclusivamenteaba.api.controller;


import com.inclusivamenteaba.api.dto.NewClientRequest;
import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid NewClientRequest clientDTO, UriComponentsBuilder uriBuilder) {
        Client client = clientService.create(clientDTO);
        var uri = uriBuilder.path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClientAndResponsible(@PathVariable Long id, @RequestBody @Valid Client client) {
        Client updatedClient = clientService.updateClientAndResponsible(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
