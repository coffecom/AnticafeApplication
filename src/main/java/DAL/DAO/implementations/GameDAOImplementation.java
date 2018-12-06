package DAL.DAO.implementations;

import DAL.Connector;
import DAL.DAO.interfaces.GameDAO;
import DAL.Entity.GameEntity;

import java.util.List;

public class GameDAOImplementation extends Connector implements GameDAO {
    @Override
    public void add(GameEntity entity) {
        currentSession.persist(entity);
    }

    @Override
    public void update(GameEntity entity) {
        currentSession.update(entity);
    }

    @Override
    public void delete(GameEntity entity) {
        currentSession.delete(entity);
    }

    @Override
    public void deleteAll() {
        for(GameEntity game: this.getAll())
            this.delete(game);
    }

    @Override
    public GameEntity getEntityById(String s) {
        return currentSession.get(GameEntity.class, s);
    }

    @Override
    public List<GameEntity> getAll() {
        return (List<GameEntity>) currentSession.createQuery("from GameEntity").list();
    }
}
