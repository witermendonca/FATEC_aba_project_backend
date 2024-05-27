package com.inclusivamenteaba.api.controller;

import com.inclusivamenteaba.api.entity.client.Client;
import com.inclusivamenteaba.api.entity.protocol.ProtocolResponse;
import com.inclusivamenteaba.api.entity.responsible.NewResponsibleRequest;
import com.inclusivamenteaba.api.entity.responsible.Responsible;
import com.inclusivamenteaba.api.entity.responsible.ResponsibleResponse;
import com.inclusivamenteaba.api.service.ClientService;
import com.inclusivamenteaba.api.service.ResponsibleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/responsible")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResponsibleController {

    private final ResponsibleService responsibleService;
    private final ClientService clientService;

    @PostMapping()
    public ResponseEntity create( @RequestBody @Valid NewResponsibleRequest responsible, UriComponentsBuilder uriBuilder) {
        Client client = clientService.findById(responsible.idClient());
        Responsible newResponsible = responsibleService.create(client, responsible);
        var uri = uriBuilder.path("/responsible/{id}").buildAndExpand(newResponsible.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public List<ResponsibleResponse> getAll() {
        return responsibleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponsibleResponse findById(@PathVariable Long id) {
        return responsibleService.findById(id);
    }

    @GetMapping("/client/{id}")
    public List<ResponsibleResponse> findAllByClientId(@PathVariable Long id) {
        return responsibleService.findAllByClientId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponsibleResponse> update(@PathVariable Long id, @RequestBody @Valid Responsible responsible) {
        Responsible updatedResponsible = responsibleService.update(id, responsible);
        return ResponseEntity.ok(new ResponsibleResponse(updatedResponsible));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        responsibleService.deleteById(id);
    }
}
