package com.project.couponing.user.service;

import com.project.couponing.common.ApiErrorCode;
import com.project.couponing.common.ApiException;
import com.project.couponing.common.ApiSuccess;
import com.project.couponing.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void validateUserExists(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new ApiException(ApiErrorCode.USER_NOT_FOUND);
        }
    }
}
