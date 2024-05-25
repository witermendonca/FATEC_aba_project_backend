package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.protocol.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProtocolRepository extends JpaRepository<Protocol, Long> {
    List<Protocol> findByClientId(Long clientId);
}
