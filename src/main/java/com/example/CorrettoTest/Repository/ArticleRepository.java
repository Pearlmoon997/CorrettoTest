package com.example.CorrettoTest.Repository;

import com.example.CorrettoTest.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    //게시판 이름으로 게시글 검색
    @Query(value = "SELECT * FROM article WHERE board_id = (SELECT id FROM board WHERE name Like %:boardName%)", nativeQuery = true)
    List<Article> findByBoardName(@Param("boardName") String boardName);

    //모든 게시글 조회
    //N+1 문제 Distinct 해결
    @Query(value = "SELECT distinct a.title as title, a.created_date_time as CreatedDateTime, b.name as boardName, att.location as Location " +
            "from article a join board b on b.id = a.board_id join attachment att on a.id = att.article_id", nativeQuery = true)
    List<ArticleMapping> findAllBy();

    //게시글 상세보기
    @Query(value = "SELECT distinct a.title as title, a.created_date_time as CreatedDateTime, b.name as boardName, att.location as Location " +
            "from article a join board b on b.id = a.board_id join attachment att on a.id = att.article_id where a.id = :articleId", nativeQuery = true)
    List<ArticleMapping> findByIdDetail(@Param("articleId") int articleId);

    //게시글 조회수 ViewCount
    @Modifying
    @Query(value = "update article a set a.view_count = a.view_count + 1 where a.id = :id", nativeQuery = true)
    int updateView(int id);

}
