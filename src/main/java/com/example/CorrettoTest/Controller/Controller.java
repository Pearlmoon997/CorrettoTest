package com.example.CorrettoTest.Controller;

import com.example.CorrettoTest.Entity.Article;
import com.example.CorrettoTest.Entity.Board;
import com.example.CorrettoTest.Repository.ArticleMapping;
import com.example.CorrettoTest.Service.ArticleService;
import com.example.CorrettoTest.Service.AttachmentService;
import com.example.CorrettoTest.Service.BoardService;
import com.example.CorrettoTest.dto.ArticleDTO;
import com.example.CorrettoTest.dto.AttachmentDTO;
import com.example.CorrettoTest.dto.BoardDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AttachmentService attachmentService;

    //게시판 생성
    @PostMapping("/api/board/create")
    public ResponseEntity<BoardDTO> Create(@RequestBody BoardDTO boardDTO) {
        BoardDTO createdDto = boardService.create(boardDTO);
        return (createdDto != null) ? ResponseEntity.status(HttpStatus.OK).body(createdDto)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //게시글 생성
    @PostMapping("/api/article/create/{boardId}")
    public ResponseEntity<ArticleDTO> Create(@RequestBody ArticleDTO articleDTO, @PathVariable int boardId) {
        ArticleDTO createdDto = articleService.create(boardId, articleDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //첨부파일 생성
    @PostMapping("/api/attachment/create/{articleId}")
    public ResponseEntity<AttachmentDTO> Create(@RequestBody AttachmentDTO attachmentDTO, @PathVariable int articleId) {
        AttachmentDTO createdDto = attachmentService.create(articleId, attachmentDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    //게시글 상세보기
    @GetMapping("/api/articles/detail/{articleId}")
    public List<ArticleMapping> detail(@PathVariable int articleId) {
        //게시글 조회수 증가
        articleService.updateView(articleId);
        return articleService.Detail(articleId);
    }

    //모든 게시글 조회
    @GetMapping("/api/articles")
    public List<ArticleMapping> list(){
        return articleService.list();
    }

    //게시판 이름으로 검색
    @GetMapping("/api/articles/{boardName}")
    public List<Article> findByBoardName(@PathVariable String boardName) {
        return articleService.listByBoardName(boardName);
    }

    //게시글 삭제
    @DeleteMapping("/api/article/delete/{id}")
    public ResponseEntity<Article> delete(@PathVariable int id) {
        Article deleted = articleService.delete(id);
        return deleted != null ? ResponseEntity.status(HttpStatus.OK).build()
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //게시글 수정
    @PatchMapping("/api/article/edit/{id}")
    public ResponseEntity<ArticleDTO> edit(@PathVariable int id, @RequestBody ArticleDTO articleDTO) {
        ArticleDTO editedDto = articleService.edit(id, articleDTO);
        log.info(String.valueOf(editedDto));
        return ResponseEntity.status(HttpStatus.OK).body(editedDto);
    }
}
