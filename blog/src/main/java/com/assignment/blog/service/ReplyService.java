package com.assignment.blog.service;

import com.assignment.blog.model.dto.ReplyRequestDto;
import com.assignment.blog.model.entitiy.Reply;
import com.assignment.blog.model.repository.ReplyRepository;
import com.assignment.blog.model.selectdata.ReplyList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {


    private final ReplyRepository replyRepository;
    //댓글 목록 조회
    public List<ReplyList> getReplyList(String postid){
        return replyRepository.findAllByPostidOrderByCreatedAtDesc(postid);
    }

    public void createReply(ReplyRequestDto requestDto){
        Reply reply = new Reply(requestDto);
        replyRepository.save(reply);
        System.out.println("댓글이 작성되었습니다.");
    }
}
