package com.example.CorrettoTest.Entity;

import com.example.CorrettoTest.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Article extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int viewCount;


    @CreatedDate
    @Column
    private LocalDateTime createdDateTime;

    public static Article createArticle(ArticleDTO articleDTO, Board board) {
        return new Article(
                articleDTO.getId(),
                board,
                articleDTO.getTitle(),
                articleDTO.getContent(),
                articleDTO.getViewCount(),
                articleDTO.getCreatedDateTime()
        );
    }

    //게시글 수정 -> 수정한 내용이 같은 내용이면 수정 못함
    public void patch(ArticleDTO articleDTO) {
        if (this.id != articleDTO.getId()) {
            throw new IllegalArgumentException("잘못된 ID");
        }
        if (articleDTO.getTitle().equals(this.getTitle())) {
            throw new IllegalArgumentException("같은 내용은 수정할 수 없음");
        } else {
            this.title = articleDTO.getTitle();
        }
        if (articleDTO.getContent().equals(this.getContent())) {
            throw new IllegalArgumentException("같은 내용은 수정할 수 없음");
        } else {
            this.content = articleDTO.getContent();
        }
    }

}
