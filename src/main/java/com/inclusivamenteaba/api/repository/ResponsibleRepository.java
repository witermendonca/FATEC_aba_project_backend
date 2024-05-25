package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.responsible.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
}
