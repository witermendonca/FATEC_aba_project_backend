package com.inclusivamenteaba.api.service;


import com.inclusivamenteaba.api.dto.NewProtocolRequest;
import com.inclusivamenteaba.api.dto.ProtocolResponse;
import com.inclusivamenteaba.api.entity.Application;
import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Protocol;
import com.inclusivamenteaba.api.repository.ProtocolRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProtocolService {

    private final ProtocolRepository repository;
    private final ClientService clientService;

    @Transactional
    public Protocol create(NewProtocolRequest protocolDTO) {
        Client client = clientService.findById(protocolDTO.getIdClient());
        Protocol protocol = protocolDTO.toModel(client);
        return repository.save(protocol);
    }

    public List<ProtocolResponse> findAll() {
        List<Protocol> protocols = repository.findAll();
        return protocols.stream().map(ProtocolResponse::new).collect(Collectors.toList());
    }

    public Protocol findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Protocol not found"));
    }

    public List<ProtocolResponse> findAllByClientId(Long clientId) {
        List<Protocol> protocols = repository.findByClientId(clientId);
        return protocols.stream().map(ProtocolResponse::new).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        Protocol protocol = this.findById(id);
        repository.deleteById(protocol.getId());
    }
}
