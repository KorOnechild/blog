package com.assignment.blog.model.repository;

import com.assignment.blog.model.entitiy.Post;
import com.assignment.blog.model.selectdata.PostList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<PostList> findAllByOrderByCreatedAtDesc();
}
