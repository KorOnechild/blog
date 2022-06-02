package com.assignment.blog.model.selectdata;


import java.time.LocalDateTime;

public interface PostList {
    String getId();
    String getNickname();
    String getTitle();
    String getContents();
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
}
