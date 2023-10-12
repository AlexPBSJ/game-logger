package io.alexpbsj.gameLogger.controller;

import io.alexpbsj.gameLogger.model.Game;
import io.alexpbsj.gameLogger.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAllGames(){
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame (@PathVariable Long id){
        return gameService.findById(id);
    }

    @PostMapping
    public Game addGame(@RequestBody Game game){
        return gameService.save(game);
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game game){
        return gameService.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id){
        gameService.deleteById(id);
    }

    @PostMapping("/{id}/played")
    public Game setPlayedGame(@PathVariable Long id){
        return gameService.setPlayed(id);
    }
}
