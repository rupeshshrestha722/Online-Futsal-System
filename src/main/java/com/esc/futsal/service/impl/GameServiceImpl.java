package com.esc.futsal.service.impl;

import com.esc.futsal.entity.Game;
import com.esc.futsal.repository.GameRepository;
import com.esc.futsal.service.GameService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameServiceImpl  implements GameService{
    private GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Game> getAllGame() {
        return gameRepository.findAll();
    }
}
