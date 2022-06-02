package com.assignment.blog.model.entitiy;

import com.assignment.blog.model.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Post extends Timestamped{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;


    public Post(PostRequestDto postRequestDto){
        this.nickname = postRequestDto.getNickname();
        this.contents = postRequestDto.getContents();
        this.title = postRequestDto.getTitle();
    }
}
