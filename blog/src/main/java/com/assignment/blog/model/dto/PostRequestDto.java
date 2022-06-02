package com.assignment.blog.model.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String nickname;
    private String title;
    private String contents;
}
