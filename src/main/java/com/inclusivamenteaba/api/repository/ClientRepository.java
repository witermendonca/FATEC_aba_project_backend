package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {
}
