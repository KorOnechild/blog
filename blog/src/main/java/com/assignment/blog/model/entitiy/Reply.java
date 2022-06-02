package com.assignment.blog.model.entitiy;

import com.assignment.blog.model.dto.ReplyRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Reply extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String postid;

    public Reply(ReplyRequestDto requestDto){
        this.reply = requestDto.getReply();
        this.nickname = requestDto.getNickname();
        this.postid = requestDto.getPostid();
    }

}
