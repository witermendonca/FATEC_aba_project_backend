package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.dto.NewResponsibleRequest;
import com.inclusivamenteaba.api.dto.ProtocolResponse;
import com.inclusivamenteaba.api.dto.ResponsibleResponse;
import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Protocol;
import com.inclusivamenteaba.api.entity.Responsible;
import com.inclusivamenteaba.api.repository.ResponsibleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResponsibleService {

    private final ResponsibleRepository repository;

    @Transactional
    public Responsible create(Client client, NewResponsibleRequest responsible) {
        Responsible newResponsible = new Responsible(responsible);
        newResponsible.setClient(client);
        return repository.save(newResponsible);
    }

    public List<ResponsibleResponse> findAll() {
        List<Responsible> responsibles = repository.findAll();
        return responsibles.stream().map(ResponsibleResponse::new).collect(Collectors.toList());
    }

    public ResponsibleResponse findById(Long id) {
        Responsible responsible = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Responsible not found"));
        return new ResponsibleResponse(responsible);
    }

    public void deleteById(Long id) {
        ResponsibleResponse responsible = this.findById(id);
        repository.deleteById(responsible.getId());
    }

    @Transactional
    public Responsible update(Long id, Responsible updateData) {
        Responsible responsible = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Responsible not found"));
        responsible.updateData(updateData);
        return repository.save(responsible);
    }
}
