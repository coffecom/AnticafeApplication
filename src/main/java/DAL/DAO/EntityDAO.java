package DAL.DAO;

import DAL.DAO.DAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class EntityDAO<Entity> implements DAO<Entity> {

    private final Class<Entity> entityClass;
    private final SessionFactory sessionFactory;

    public EntityDAO(SessionFactory sessionFactory, Class<Entity> entityClass) {
        this.sessionFactory=sessionFactory;
        this.entityClass = entityClass;
        //sessionFactory.openSession();
    }

    private void startTransaction(){
        //sessionFactory.openSession();
        sessionFactory.getCurrentSession().beginTransaction();
    }


    private void commitTransaction(){
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
    @Override
    public void add(Entity entity) {
        startTransaction();
        sessionFactory.getCurrentSession().persist(entity);
        commitTransaction();
    }

    @Override
    public void update(Entity entity) {
        startTransaction();
        sessionFactory.getCurrentSession().update(entity);
        commitTransaction();
    }

    @Override
    public void delete(Entity entity) {
        startTransaction();
        sessionFactory.getCurrentSession().delete(entity);
        commitTransaction();
    }

    @Override
    public void deleteAll() {
        for(Entity entity: getAll())
            this.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> getAll() {
        startTransaction();
        List<Entity> list = (List<Entity>) sessionFactory.getCurrentSession().createQuery("from " + entityClass.getName()).list();
        commitTransaction();
        return list;
    }
}
