package io.alexpbsj.gameLogger.service;

import io.alexpbsj.gameLogger.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.alexpbsj.gameLogger.repository.GameRepository;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Game findById(Long id){
        return gameRepository.findById(id).orElse(null);
    }

    public Game save(Game game){
        return gameRepository.save(game);
    }

    public void deleteById(Long id){
        gameRepository.deleteById(id);
    }

    public Game setPlayed(Long id){
        Game game = findById(id);

        if(!game.isPlayed()) {
            game.setPlayed(true);
            return save(game);
        }

        return null;
    }
}
