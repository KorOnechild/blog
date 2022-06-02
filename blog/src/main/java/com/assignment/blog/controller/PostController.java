package com.assignment.blog.controller;

import com.assignment.blog.model.dto.PostRequestDto;
import com.assignment.blog.model.entitiy.Post;
import com.assignment.blog.model.selectdata.PostList;
import com.assignment.blog.security.UserDetailsImpl;
import com.assignment.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;

    //게시글 작성 페이지
    @Secured("ROLE_USER")
    @GetMapping("/post/write")
    public String getWrite(Model model, @AuthenticationPrincipal UserDetailsImpl user){
        model.addAttribute("user", user);
        return "write";
    }

    //게시글 목록 조회
    @ResponseBody
    @GetMapping("/post/list")
    public List<PostList> getPostList(){
        return postService.getPostList();
    }

    //게시물 조회
    @GetMapping("/post/{id}")
    public String getPost(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetailsImpl user){
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        return "post";
    }


    //게시글 작성
    @Secured("ROLE_USER")
    @ResponseBody
    @PostMapping("/post/create")
    public PostRequestDto createPost(@RequestBody PostRequestDto requestDto){
        postService.createPost(requestDto);
        return requestDto;
    }
    //게시글 수정
    //게시글 삭제
}
