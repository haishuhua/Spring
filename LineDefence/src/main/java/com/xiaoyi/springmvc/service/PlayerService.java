package com.xiaoyi.springmvc.service;
 
import java.util.List;
 
import com.xiaoyi.springmvc.model.Player;
 
public interface PlayerService {
 
    Player findById(int id);
     
    void savePlayer(Player player);
     
    List<Player> findAllPlayers(); 
        
}