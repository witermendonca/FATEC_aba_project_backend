package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.dto.NewClientRequest;
import com.inclusivamenteaba.api.dto.NewResponsibleRequest;
import com.inclusivamenteaba.api.entity.Client;
import com.inclusivamenteaba.api.entity.Responsible;
import com.inclusivamenteaba.api.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository repository;
    private final ResponsibleService responsibleService;

    @Transactional
    public Client create(NewClientRequest clientDTO) {
        Client client = clientDTO.toModel();
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
                    NewResponsibleRequest responsibleRequest = new NewResponsibleRequest(updatedResponsible);
                    responsibleService.create(client, responsibleRequest);
                }
            }
        }

        return repository.save(client);
    }

}
