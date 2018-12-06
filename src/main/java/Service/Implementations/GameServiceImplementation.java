package Service.Implementations;

import DAL.DAO.interfaces.GameDAO;
import DAL.Entity.GameEntity;
import Service.Interfaces.GameService;
import Service.Interfaces.Service;

import java.util.List;

public class GameServiceImplementation implements GameService {
    private GameDAO dao;

    public GameServiceImplementation(GameDAO dao) {
        this.dao = dao;
    }

    public GameEntity getGame(String title) {
        dao.openSession();
        GameEntity game = dao.getEntityById(title);
        dao.closeSession();
        return game;
    }

    public List<GameEntity> getAll() {
        dao.openSession();
        List<GameEntity> list = dao.getAll();
        dao.closeSession();
        return list;
    }

    public void add(GameEntity game) {
        dao.openSessionWithTransaction();
        dao.add(game);
        dao.closeSessionWithTransaction();
    }

    public void update(GameEntity game) {
        dao.openSessionWithTransaction();
        dao.update(game);
        dao.closeSessionWithTransaction();
    }

    public void delete(GameEntity game) {
        dao.openSessionWithTransaction();
        dao.delete(game);
        dao.closeSessionWithTransaction();
    }

    public void deleteAll() {
        dao.openSessionWithTransaction();
        dao.deleteAll();
        dao.closeSessionWithTransaction();
    }
}
