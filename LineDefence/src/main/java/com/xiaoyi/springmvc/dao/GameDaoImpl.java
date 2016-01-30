package com.xiaoyi.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.xiaoyi.springmvc.model.Game;
 
@Repository("gameDao")
public class GameDaoImpl extends AbstractDao<Integer, Game> implements GameDao {
 
    public Game findById(int id) {
        return getByKey(id);
    }
 
    public void saveGame(Game game) {
        persist(game);
    }

 
    @SuppressWarnings("unchecked")
    public List<Game> findAllGames() {
        Criteria criteria = createEntityCriteria();
        return (List<Game>) criteria.list();
    }
 
   
}