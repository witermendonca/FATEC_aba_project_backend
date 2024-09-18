package com.inclusivamenteaba.api.controller;

import com.inclusivamenteaba.api.entity.application.NewApplicationRequest;
import com.inclusivamenteaba.api.entity.application.Application;
import com.inclusivamenteaba.api.entity.application.ApplicationResponse;
import com.inclusivamenteaba.api.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/application")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationController {

    private final ApplicationService service;

    @PostMapping
    public ResponseEntity<UriComponentsBuilder> create(@RequestBody @Valid NewApplicationRequest applicationDTO, UriComponentsBuilder uriBuilder) {
        System.out.println(applicationDTO);
        Application application = service.create(applicationDTO);
        var uri = uriBuilder.path("/application/{id}").buildAndExpand(application.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public List<ApplicationResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ApplicationResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/protocol/{id}")
    public List<ApplicationResponse> findAllByProtocolId(@PathVariable Long id) {
        return service.findAllByProtocolId(id);
    }

}
