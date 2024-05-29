package com.inclusivamenteaba.api.controller;



import com.inclusivamenteaba.api.entity.client.ClientDetailsResponse;
import com.inclusivamenteaba.api.entity.client.ClientRequest;
import com.inclusivamenteaba.api.entity.client.Client;
import com.inclusivamenteaba.api.entity.client.ItemListClientResponse;
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
    public ResponseEntity create(@RequestBody @Valid ClientRequest newClientRequest, UriComponentsBuilder uriBuilder) {
        Client client = clientService.create(newClientRequest);
        var uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public List<ItemListClientResponse> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDetailsResponse findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return new ClientDetailsResponse(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDetailsResponse> updateClientAndResponsible(@PathVariable Long id, @RequestBody @Valid Client client) {
        ClientDetailsResponse updatedClient = clientService.updateClientAndResponsible(id, client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
