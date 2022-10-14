package com.example.CorrettoTest.Service;

import com.example.CorrettoTest.Entity.Article;
import com.example.CorrettoTest.Entity.Board;
import com.example.CorrettoTest.Repository.ArticleMapping;
import com.example.CorrettoTest.Repository.ArticleRepository;
import com.example.CorrettoTest.Repository.BoardRepository;
import com.example.CorrettoTest.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private BoardRepository boardRepository;

    //게시글 생성
    @Transactional
    public ArticleDTO create(int boardId, ArticleDTO articleDTO) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("해당 board 가 없음"));

        Article article = Article.createArticle(articleDTO, board);

        Article created = articleRepository.save(article);

        return ArticleDTO.createArticleDto(created);
    }

    //게시글 상세보기
    public List<ArticleMapping> Detail(int articleId) {
        return articleRepository.findByIdDetail(articleId);
    }

    //모든 게시글 조회
    public List<ArticleMapping> list() {
        return articleRepository.findAllBy();
    }

    //게시판 이름으로 게시글 검색
    public List<Article> listByBoardName(String boardName) {
        return articleRepository.findByBoardName(boardName);
    }

    //게시글 삭제
    @Transactional
    public Article delete(int id) {
        Article target = articleRepository.findById(id).orElse(null);

        articleRepository.delete(target);

        return target;
    }

    //게시글 수정
    @Transactional
    public ArticleDTO edit(int id, ArticleDTO articleDTO) {
        Article target = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당하는 게시글이 없음"));
        target.patch(articleDTO);
        Article edited = articleRepository.save(target);
        return ArticleDTO.createArticleDto(edited);
    }

    //게시글 조회수 증가
    @Transactional
    public int updateView(int id) {
        return articleRepository.updateView(id);
    }
}
