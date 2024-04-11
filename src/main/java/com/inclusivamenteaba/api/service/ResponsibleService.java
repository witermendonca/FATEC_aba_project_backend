package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Responsible;
import com.inclusivamenteaba.api.repository.ResponsibleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ResponsibleService {

    private final ResponsibleRepository repository;

    @Transactional
    public Responsible create(Client client, Responsible responsible) {
        responsible.setClient(client);
        return repository.save(responsible);
    }

    public List<Responsible> findAll() {
        return repository.findAll();
    }

    public Responsible findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Responsible not found"));
    }

    public void deleteById(Long id) {
        Responsible responsible = this.findById(id);
        repository.deleteById(responsible.getId());
    }

    @Transactional
    public Responsible update(Long id,Responsible updateData) {
        Responsible responsible = this.findById(id);
        responsible.updateData(updateData);
        return repository.save(responsible);
    }
}
