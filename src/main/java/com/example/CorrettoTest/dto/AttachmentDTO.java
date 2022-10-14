package com.example.CorrettoTest.dto;

import com.example.CorrettoTest.Entity.Attachment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AttachmentDTO {
    private int id;
    @JsonProperty("article_id")
    private int articleId;
    private String location;
    private LocalDateTime createdDateTime;

    //첨부파일 DTO 생성
    public static AttachmentDTO createAttachmentDto(Attachment attachment) {
        return new AttachmentDTO(
                attachment.getId(),
                attachment.getArticle().getId(),
                attachment.getLocation(),
                attachment.getCreatedDateTime()
        );
    }

}
