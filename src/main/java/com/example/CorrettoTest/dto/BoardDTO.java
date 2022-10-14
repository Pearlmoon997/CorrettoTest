package com.example.CorrettoTest.dto;

import com.example.CorrettoTest.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BoardDTO {

    private int id;
    private String name;

    public static BoardDTO createBoardDto(Board board) {
        return new BoardDTO(
                board.getId(),
                board.getName()
        );
    }


}
