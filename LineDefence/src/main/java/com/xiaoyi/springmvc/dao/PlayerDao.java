package com.xiaoyi.springmvc.dao;
 
import java.util.List;
 
import com.xiaoyi.springmvc.model.Player;
 
public interface PlayerDao {
 
	Player findById(int id);
 
    void savePlayer(Player player);
         
    List<Player> findAllPlayers();
 
}