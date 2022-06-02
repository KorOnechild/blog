package com.assignment.blog.service;

import com.assignment.blog.model.dto.SignupRequestDto;
import com.assignment.blog.model.entitiy.UserRoleEnum;
import com.assignment.blog.model.entitiy.Users;
import com.assignment.blog.model.repository.UserRepository;
import com.assignment.blog.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(SignupRequestDto requestDto){
        Users user = new Users(requestDto);

        Optional<Users> found = userRepository.findByUsername(user.getUsername());
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        //USER권한 부여
        user.setRole(UserRoleEnum.USER);
        // 패스워드 암호화
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        userRepository.save(user);
    }
}
