package com.xiaoyi.springmvc.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import com.xiaoyi.springmvc.model.Player;
 
@Repository("playerDao")
public class PlayerDaoImpl extends AbstractDao<Integer, Player> implements PlayerDao {
 
    public Player findById(int id) {
        return getByKey(id);
    }
 
    public void savePlayer(Player player) {
        persist(player);
    }

 
    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }
 
   
}