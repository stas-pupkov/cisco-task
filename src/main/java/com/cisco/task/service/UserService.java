package com.cisco.task.service;

import com.cisco.task.dto.User;
import com.cisco.task.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        log.info("For userId={} found user={}", id, user.orElse(null));
        return user.orElse(null);
    }

    public User save(User user) {
        User newUser = userRepository.save(user);
        log.info("Saved new user with userId={}", newUser.getUserId());
        return newUser;
    }
}
