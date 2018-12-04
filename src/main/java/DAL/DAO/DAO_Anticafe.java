package DAL.DAO;

import DAL.Entity.EntityAnticafe;
import DAL.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DAO_Anticafe implements DAO<EntityAnticafe, Integer> {

    private Session currentSession;

    private Transaction currentTransaction;

    public Session openSession(){
        currentSession = HibernateSessionFactory.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openSessionWithTransaction(){
        currentSession = HibernateSessionFactory.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeSession(){
        currentSession.close();
    }

    public void closeSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public void add(EntityAnticafe entity) {
        currentSession.persist(entity);
    }

    @Override
    public void update(EntityAnticafe entity) {
        currentSession.update(entity);
    }

    @Override
    public void delete(EntityAnticafe entity) {
        currentSession.delete(entity);

    }

    @Override
    public void deleteAll() {
        for(EntityAnticafe anticafe : getAll()){
            this.delete(anticafe);
        }
    }

    @Override
    public EntityAnticafe getEntityById(Integer id) {
        EntityAnticafe anticafe = currentSession.get(EntityAnticafe.class, id);
        return anticafe;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<EntityAnticafe> getAll() {
        List<EntityAnticafe> list =currentSession.createQuery("from EntityAnticafe").list();
        return list;
    }
}
