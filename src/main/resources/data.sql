-- 게시판 더미데이터
INSERT INTO board(id, name) VALUES (1, '1번 테스트 게시판');
INSERT INTO board(id, name) VALUES (2, '2번 테스트 게시판');

-- 게시글 더미데이터
INSERT INTO article(id, board_id, title, content, view_count, created_date_time) VALUES (1, 1, '1번 테스트 게시글', '1번 테스트 본문', '1', current_timestamp);
INSERT INTO article(id, board_id, title, content, view_count, created_date_time) VALUES (2, 2, '2번 테스트 게시글', '2번 테스트 본문', '1', current_timestamp);

--첨부파일 더미데이터
INSERT INTO attachment(id, article_id, location, created_date_time) VALUES (1, 1, '1번 게시글 첨부', current_timestamp);
INSERT INTO attachment(id, article_id, location, created_date_time) VALUES (2, 2, '2번 게시글 첨부', current_timestamp);
