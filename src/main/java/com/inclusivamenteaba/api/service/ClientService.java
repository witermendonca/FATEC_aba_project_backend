package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.entity.client.Client;
import com.inclusivamenteaba.api.entity.client.ClientRequest;
import com.inclusivamenteaba.api.entity.responsible.Responsible;
import com.inclusivamenteaba.api.repository.ClientRepository;
import com.inclusivamenteaba.api.repository.ResponsibleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository repository;
    private final ResponsibleRepository responsibleRepository;

    @Transactional
    public Client create(ClientRequest newClientRequest) {
        Client client = newClientRequest.toModel();
        return repository.save(client);
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public void deleteById(Long id) {
        Client client = this.findById(id);
        repository.deleteById(client.getId());
    }

    @Transactional
    public Client updateClientAndResponsible(Long clientId, Client clientData) {
        Client client = this.findById(clientId);
        client.updateData(clientData);

        if(clientData.getResponsible() != null) {
            List<Responsible> updatedResponsibles = clientData.getResponsible();

            for (Responsible updatedResponsible : updatedResponsibles) {
                Optional<Responsible> existingResponsibleOpt = client.getResponsible().stream()
                        .filter(existing -> existing.getId().equals(updatedResponsible.getId()))
                        .findFirst();
                if (existingResponsibleOpt.isPresent()) {
                    Responsible existingResponsible = existingResponsibleOpt.get();
                    existingResponsible.updateData(updatedResponsible);
                } else {
                    updatedResponsible.setClient(client);
                    updatedResponsible.setCreatedAt(LocalDateTime.now());
                    responsibleRepository.save(updatedResponsible);
                }
            }
        }

        return repository.save(client);
    }

}
