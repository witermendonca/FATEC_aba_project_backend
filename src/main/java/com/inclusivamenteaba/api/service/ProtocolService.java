package com.inclusivamenteaba.api.service;


import com.inclusivamenteaba.api.entity.client.Client;
import com.inclusivamenteaba.api.entity.protocol.ItemListProtocolResponse;
import com.inclusivamenteaba.api.entity.protocol.Protocol;
import com.inclusivamenteaba.api.entity.protocol.NewProtocolRequest;
import com.inclusivamenteaba.api.entity.protocol.ProtocolResponse;
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
    public Protocol create(NewProtocolRequest newProtocol) {
        Client client = clientService.findById(newProtocol.idClient());
        Protocol protocol = newProtocol.toModel(client);
        return repository.save(protocol);
    }
    @Transactional
    public List<ItemListProtocolResponse> findAll() {
        List<Protocol> protocols = repository.findAll();
        return protocols.stream().map(ItemListProtocolResponse::new).collect(Collectors.toList());
    }
    @Transactional
    public Protocol findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Protocol not found"));
    }
    @Transactional
    public List<ProtocolResponse> findAllByClientId(Long clientId) {
        List<Protocol> protocols = repository.findByClientId(clientId);
        return protocols.stream().map(ProtocolResponse::new).collect(Collectors.toList());
    }
    @Transactional
    public void deleteById(Long id) {
        Protocol protocol = this.findById(id);
        repository.deleteById(protocol.getId());
    }
}
