package DAL.DAO.implementations;
import DAL.Connector;
import DAL.DAO.interfaces.AnticafeDAO;
import DAL.Entity.AnticafeEntity;
import java.util.List;

public class AnticafeDAOImplementation extends Connector implements AnticafeDAO {

    @Override
    public void add(AnticafeEntity entity) {
        currentSession.persist(entity);
    }

    @Override
    public void update(AnticafeEntity entity) {
        currentSession.update(entity);
    }

    @Override
    public void delete(AnticafeEntity entity) {
        currentSession.delete(entity);

    }

    @Override
    public void deleteAll() {
        for(AnticafeEntity anticafe : getAll()){
            this.delete(anticafe);
        }
    }

    @Override
    public AnticafeEntity getEntityById(Integer id) {
        AnticafeEntity anticafe = currentSession.get(AnticafeEntity.class, id);
        return anticafe;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AnticafeEntity> getAll() {
        List<AnticafeEntity> list =currentSession.createQuery("from AnticafeEntity").list();
        return list;
    }
}
