package com.esc.futsal.controller;

import com.esc.futsal.entity.Game;
import com.esc.futsal.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {


    private GameService gameService;


    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/viewGame")
    public String viewFlight(Model model){

        List<Game> gameList = gameService.getAllGame();
        model.addAttribute("game", gameList);
        return "admin/viewGame";
    }
}
