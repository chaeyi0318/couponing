package com.project.couponing.user.service;

import com.project.couponing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public boolean validateUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            return false;
        }
        return true;
    }

}
