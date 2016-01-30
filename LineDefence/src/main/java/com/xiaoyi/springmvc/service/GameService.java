package com.xiaoyi.springmvc.service;
 
import java.util.List;
 
import com.xiaoyi.springmvc.model.Game;
 
public interface GameService {
 
    Game findById(int id);
     
    void saveGame(Game game);
     
    void updateGame(Game game);
    
    int countWin();
     
    List<Game> findAllGames(); 
        
}