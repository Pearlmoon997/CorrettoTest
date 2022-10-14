package com.example.CorrettoTest.Repository;

import com.example.CorrettoTest.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {
}
