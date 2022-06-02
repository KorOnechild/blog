package com.assignment.blog.controller;

import com.assignment.blog.model.dto.SignupRequestDto;
import com.assignment.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

/*-----------------<페이지 조회 API>-----------------*/

    @GetMapping("/home")
    public String getLoginHomePage(){
        return "login_home";
    }

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }
    //회원가입페이지
    @GetMapping("/user/signup")
    public String getSignupPage(){
        return "signup";
    }

    //로그인페이지
    @GetMapping("/user/login")
    public String getLoginPage(){
        return "login";
    }
/*----------------<회원가입 기능 API>----------------*/
    //회원가입요청
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto){
        userService.registerUser(requestDto);
        return "login";
    }
}
