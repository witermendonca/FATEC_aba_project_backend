package com.inclusivamenteaba.api.controller;

import com.inclusivamenteaba.api.entity.protocol.Protocol;
import com.inclusivamenteaba.api.entity.protocol.NewProtocolRequest;
import com.inclusivamenteaba.api.entity.protocol.ProtocolResponse;
import com.inclusivamenteaba.api.service.ProtocolService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/protocol")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProtocolController {

    private final ProtocolService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid NewProtocolRequest newProtocol, UriComponentsBuilder uriBuilder) {
        Protocol protocol = service.create(newProtocol);
        var uri = uriBuilder.path("/{id}").buildAndExpand(protocol.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public List<ProtocolResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProtocolResponse findById(@PathVariable Long id) {
        Protocol protocol = service.findById(id);
        return new ProtocolResponse(protocol);
    }

    @GetMapping("/client/{id}")
    public List<ProtocolResponse> findAllByClientId(@PathVariable Long id) {
        return service.findAllByClientId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
