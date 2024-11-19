package com.inclusivamenteaba.api.repository;

import com.inclusivamenteaba.api.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
