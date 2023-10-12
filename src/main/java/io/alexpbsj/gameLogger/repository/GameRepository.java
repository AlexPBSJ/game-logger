package io.alexpbsj.gameLogger.repository;

import io.alexpbsj.gameLogger.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
