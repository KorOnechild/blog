package com.assignment.blog.controller;

import com.assignment.blog.model.dto.ReplyRequestDto;
import com.assignment.blog.model.selectdata.ReplyList;
import com.assignment.blog.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReplyController {

    private final ReplyService replyService;

    //댓글 목록 조회
    @ResponseBody
    @PostMapping("/reply/list")
    public List<ReplyList> getReplyList(String postid){
        return replyService.getReplyList(postid);
    }

    @ResponseBody
    @Secured("ROLE_USER")
    @PostMapping("/reply/create")
    public ReplyRequestDto createReply(@RequestBody ReplyRequestDto requestDto){
        replyService.createReply(requestDto);
        return requestDto;
    }
}
