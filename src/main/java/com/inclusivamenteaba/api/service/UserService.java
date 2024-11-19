package com.inclusivamenteaba.api.service;

import com.inclusivamenteaba.api.entity.user.User;
import com.inclusivamenteaba.api.entity.user.UserRequest;
import com.inclusivamenteaba.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User create(UserRequest userRequest) {
        User newUser = new User();
        newUser.setName(userRequest.name());
        newUser.setEmail(userRequest.email());
        newUser.setPassword(passwordEncoder.encode(userRequest.password()));
        newUser.setAdmin(userRequest.admin());
        newUser.setCreatedAt(LocalDateTime.now());
        return repository.save(newUser);
    }

    public List<User> findAll() {
        List<User> users = repository.findAll();
        return users;
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public void deleteById(Long id) {
        User user = this.findById(id);
        repository.deleteById(user.getId());
    }
}
