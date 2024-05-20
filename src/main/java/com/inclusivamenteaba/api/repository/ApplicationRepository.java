package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByProtocolId(Long protocolId);
}
