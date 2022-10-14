package com.example.CorrettoTest.Repository;


import java.util.List;

//JOIN 후 프로젝션 인터페이스 -> 원하는 컬럼 출력
public interface ArticleMapping {
    String getTitle();
    String getCreatedDateTime();
    String getBoardName();
    String getLocation();


}
