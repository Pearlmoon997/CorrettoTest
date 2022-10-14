package com.example.CorrettoTest.Service;

import com.example.CorrettoTest.Entity.Article;
import com.example.CorrettoTest.Entity.Attachment;
import com.example.CorrettoTest.Repository.ArticleRepository;
import com.example.CorrettoTest.Repository.AttachmentRepository;
import com.example.CorrettoTest.dto.AttachmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    //첨부파일 생성
    @Transactional
    public AttachmentDTO create(int articleId, AttachmentDTO attachmentDTO) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없음"));

        Attachment attachment = Attachment.createAttachment(attachmentDTO, article);

        Attachment created = attachmentRepository.save(attachment);

        return AttachmentDTO.createAttachmentDto(created);
    }
}
