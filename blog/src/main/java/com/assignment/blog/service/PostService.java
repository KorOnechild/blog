package com.assignment.blog.service;

import com.assignment.blog.model.dto.PostRequestDto;
import com.assignment.blog.model.entitiy.Post;
import com.assignment.blog.model.repository.PostRepository;
import com.assignment.blog.model.selectdata.PostList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //게시물 목록 불러오기
    public List<PostList> getPostList(){
        return postRepository.findAllByOrderByCreatedAtDesc();
    }
    //게시글 작성
    public void createPost(PostRequestDto requestDto){
        Post post = new Post(requestDto);
        postRepository.save(post);
        System.out.println("게시글이 작성되었습니다.");
    }

    //게시글 조회
    public Post getPost(Long id){
        return postRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
    }
}
