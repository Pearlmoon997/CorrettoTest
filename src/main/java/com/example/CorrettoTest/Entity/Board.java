package com.example.CorrettoTest.Entity;

import com.example.CorrettoTest.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    public static Board createBoard(BoardDTO boardDTO) {
        return new Board(
                boardDTO.getId(),
                boardDTO.getName()
        );
    }
}
