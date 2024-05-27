package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.protocol.Protocol;
import com.inclusivamenteaba.api.entity.responsible.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
    List<Responsible> findByClientId(Long clientId);
}
