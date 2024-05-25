package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.entity.application.NewApplicationRequest;
import com.inclusivamenteaba.api.entity.application.Application;
import com.inclusivamenteaba.api.entity.application.ApplicationResponse;
import com.inclusivamenteaba.api.entity.protocol.Protocol;
import com.inclusivamenteaba.api.repository.ApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationService {
    private final ApplicationRepository repository;
    private final ProtocolService protocolService;

    @Transactional
    public Application create(NewApplicationRequest applicationRequest) {
        Protocol protocol = protocolService.findById(applicationRequest.protocolId());
        Application application = applicationRequest.toModel(protocol);
        return repository.save(application);
    }

    public List<ApplicationResponse> findAll() {
        List<Application> applications = repository.findAll();
        return applications.stream().map(ApplicationResponse::new).collect(Collectors.toList());
    }

    public ApplicationResponse findById(Long id) {
        Application application = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Application not found"));
        return new ApplicationResponse(application);
    }

    public List<ApplicationResponse> findAllByProtocolId(Long protocolId) {
        List<Application> applications =  repository.findByProtocolId(protocolId);
        return applications.stream().map(ApplicationResponse::new).collect(Collectors.toList());
    }

}
