package com.xiaoyi.springmvc.dao;
 
import java.util.List;
 
import com.xiaoyi.springmvc.model.Game;
 
public interface GameDao {
 
	Game findById(int id);
 
    void saveGame(Game game);
         
    List<Game> findAllGames();
 
}