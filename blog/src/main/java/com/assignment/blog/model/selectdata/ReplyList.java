package com.assignment.blog.model.selectdata;

import java.time.LocalDateTime;

public interface ReplyList {
    String getId();
    String getPostid();
    String getReply();
    String getNickname();
    LocalDateTime getCreatedAt();
    LocalDateTime getModifiedAt();
}
