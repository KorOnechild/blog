package com.assignment.blog.model.repository;

import com.assignment.blog.model.entitiy.Reply;
import com.assignment.blog.model.selectdata.ReplyList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<ReplyList> findAllByPostidOrderByCreatedAtDesc(String postid);
}
