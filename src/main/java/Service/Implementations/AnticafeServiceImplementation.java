package Service.Implementations;

import DAL.DAO.interfaces.AnticafeDAO;
import DAL.Entity.AnticafeEntity;
import Service.Interfaces.AnticafeService;

import java.util.List;

public class AnticafeServiceImplementation implements AnticafeService {
    private AnticafeDAO dao;

    public AnticafeServiceImplementation(AnticafeDAO dao) {
        this.dao = dao;
    }

    @Override
    public AnticafeEntity getGame(Integer integer) {
        dao.openSession();
        AnticafeEntity anticafe = dao.getEntityById(integer);
        dao.closeSession();
        return anticafe;
    }

    @Override
    public List<AnticafeEntity> getAll() {
        dao.openSession();
        List<AnticafeEntity> list = dao.getAll();
        dao.closeSession();
        return list;
    }

    @Override
    public void add(AnticafeEntity entity) {
        dao.openSessionWithTransaction();
        dao.add(entity);
        dao.closeSession();
    }

    @Override
    public void update(AnticafeEntity entity) {
        dao.openSession();
        dao.update(entity);
        dao.closeSession();
    }

    @Override
    public void delete(AnticafeEntity entity) {
        dao.openSessionWithTransaction();
        dao.delete(entity);
        dao.closeSessionWithTransaction();
    }

    @Override
    public void deleteAll() {
        dao.openSessionWithTransaction();
        dao.deleteAll();
        dao.closeSessionWithTransaction();
    }
}
