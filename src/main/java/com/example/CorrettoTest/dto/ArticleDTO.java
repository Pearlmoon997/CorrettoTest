package com.example.CorrettoTest.dto;

import com.example.CorrettoTest.Entity.Article;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter
public class ArticleDTO {

    private int id;
    @JsonProperty("board_id")
    private int boardId;

    private String title;
    private String content;
    private int viewCount;

    private LocalDateTime createdDateTime;

    //게시글 DTO 생성
    public static ArticleDTO createArticleDto(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getBoard().getId(),
                article.getTitle(),
                article.getContent(),
                article.getViewCount(),
                article.getCreatedDateTime()
        );
    }
}
