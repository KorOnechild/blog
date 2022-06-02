package com.assignment.blog.model.dto;

import com.assignment.blog.model.entitiy.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String nickname;
    private String password;
    private UserRoleEnum role;
}
