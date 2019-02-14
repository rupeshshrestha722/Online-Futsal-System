package com.esc.futsal.repository;

import com.esc.futsal.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    Iterable<Game> findByDateAndTime(String date, String time);
}
