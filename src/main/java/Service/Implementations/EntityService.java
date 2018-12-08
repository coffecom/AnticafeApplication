package Service.Implementations;

import DAL.DAO.implementations.EntityDAO;
import DAL.DAO.interfaces.DAO;
import DAL.Entity.AnticafeEntity;
import DAL.HibernateSessionFactory;
import Service.Interfaces.Service;
import org.hibernate.SessionFactory;

import java.util.List;

public class EntityService<Entity> implements Service<Entity> {
    private final DAO<Entity> dao;

    public EntityService(DAO<Entity> dao) {
        this.dao = dao;
    }

    public EntityService(SessionFactory sessionFactory, Class<Entity> _class){
        this.dao=new EntityDAO<>(sessionFactory,_class);
    }
    @Override
    public List<Entity> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(Entity entity) {
        dao.add(entity);
    }

    @Override
    public void update(Entity entity) {
        dao.update(entity);
    }

    @Override
    public void delete(Entity entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    public static void main(String[] args){

    }
}
