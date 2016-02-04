package com.xiaoyi.springmvc.service;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoyi.springmvc.model.Player;
import com.xiaoyi.springmvc.dao.PlayerDao;
 
@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
 
    @Autowired
    private PlayerDao dao;
    @Autowired
    private SessionFactory sessionFactory;
     
    public Player findById(int id) {
        return dao.findById(id);
    }
 
    public void savePlayer(Player Player) {
        dao.savePlayer(Player);
    }
 
   
     
    public List<Player> findAllPlayers() {
        return dao.findAllPlayers();
    }
 
  
     
}