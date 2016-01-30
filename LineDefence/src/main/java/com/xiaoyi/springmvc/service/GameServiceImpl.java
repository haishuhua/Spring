package com.xiaoyi.springmvc.service;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoyi.springmvc.model.Game;
import com.xiaoyi.springmvc.dao.GameDao;
 
@Service("gameService")
@Transactional
public class GameServiceImpl implements GameService {
 
    @Autowired
    private GameDao dao;
    @Autowired
    private SessionFactory sessionFactory;
     
    public Game findById(int id) {
        return dao.findById(id);
    }
 
    public void saveGame(Game game) {
        dao.saveGame(game);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateGame(Game game) {
        Game entity = dao.findById(game.getId());
        if(entity!=null){
            entity.setTeamA1(game.getTeamA1());
            entity.setTeamA2(game.getTeamA2());
            entity.setTeamB1(game.getTeamB1());
            entity.setTeamB2(game.getTeamB2());
            entity.setPlayDate(game.getPlayDate());
            entity.setScore(game.getScore());
        }
    }
   
    public int countWin()
    {
    	 Query query = sessionFactory.
    		      getCurrentSession().
    		      createSQLQuery("select * FROM LineDefence where ScoreAvsB like '10%'");
    	 List<?> list = query.list();
    	return list.size();
    }
   
     
    public List<Game> findAllGames() {
        return dao.findAllGames();
    }
 
  
     
}