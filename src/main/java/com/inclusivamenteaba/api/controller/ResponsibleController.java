package com.inclusivamenteaba.api.controller;

import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Responsible;
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

    @PostMapping("/{id}")
    public ResponseEntity create(@PathVariable Long id, @RequestBody @Valid Responsible responsible, UriComponentsBuilder uriBuilder) {
        Client client = clientService.findById(id);
        Responsible newResponsible = responsibleService.create(client, responsible);
        var uri = uriBuilder.path("/{id}").buildAndExpand(newResponsible.getId()).toUri();
        return ResponseEntity.created(uri).body(newResponsible);
    }

    @GetMapping
    public List<Responsible> getAll() {
        return responsibleService.findAll();
    }

    @GetMapping("/{id}")
    public Responsible findById(@PathVariable Long id) {
        return responsibleService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsible> update(@PathVariable Long id, @RequestBody @Valid Responsible responsible) {
        Responsible updatedResponsible = responsibleService.update(id, responsible);
        return ResponseEntity.ok(updatedResponsible);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        responsibleService.deleteById(id);
    }
}
