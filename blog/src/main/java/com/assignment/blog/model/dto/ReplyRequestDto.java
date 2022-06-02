package com.assignment.blog.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyRequestDto {
    private String nickname;
    private String reply;
    private String postid;
}
