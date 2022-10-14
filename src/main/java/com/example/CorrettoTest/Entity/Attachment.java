package com.example.CorrettoTest.Entity;

import com.example.CorrettoTest.dto.AttachmentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Attachment extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String location;

    @CreatedDate
    @Column
    private LocalDateTime createdDateTime;

    public static Attachment createAttachment(AttachmentDTO attachmentDTO, Article article) {
        return new Attachment(
                attachmentDTO.getId(),
                article,
                attachmentDTO.getLocation(),
                attachmentDTO.getCreatedDateTime()
        );
    }
}
