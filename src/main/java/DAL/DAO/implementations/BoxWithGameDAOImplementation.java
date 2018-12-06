package DAL.DAO.implementations;
import DAL.Connector;
import DAL.DAO.interfaces.BoxWithGameDAO;
import DAL.Entity.BoxWithGameEntity;
import java.util.List;

public class BoxWithGameDAOImplementation extends Connector implements BoxWithGameDAO {

    @Override
    public void add(BoxWithGameEntity entity) {
        currentSession.persist(entity);
    }

    @Override
    public void update(BoxWithGameEntity entity) {
        currentSession.update(entity);
    }

    @Override
    public void delete(BoxWithGameEntity entity) {
        currentSession.delete(entity);
    }

    @Override
    public void deleteAll() {
        for (BoxWithGameEntity entityBoxWithGame : this.getAll())
            this.delete(entityBoxWithGame);
    }

    @Override
    public BoxWithGameEntity getEntityById(Integer integer) {
        return currentSession.get(BoxWithGameEntity.class, integer);
    }

    @Override
    public List<BoxWithGameEntity> getAll() {
        List<BoxWithGameEntity> list = currentSession.createQuery("from BoxWithGameEntity").list();
        return list;
    }
}