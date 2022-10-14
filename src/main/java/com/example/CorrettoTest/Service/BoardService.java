package com.example.CorrettoTest.Service;

import com.example.CorrettoTest.Entity.Board;
import com.example.CorrettoTest.Repository.BoardRepository;
import com.example.CorrettoTest.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    @Transactional
    public BoardDTO create(BoardDTO boardDTO) {
        Board board = Board.createBoard(boardDTO);

        Board created = boardRepository.save(board);

        return BoardDTO.createBoardDto(created);
    }
}
