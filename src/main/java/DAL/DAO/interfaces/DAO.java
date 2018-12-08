package DAL.DAO.interfaces;

import DAL.Connector;
import DAL.HibernateSessionFactory;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Predicate;

public interface DAO<T> {
 /*   Session openSession();

    Session openSessionWithTransaction();

    void closeSession();

    void closeSessionWithTransaction();*/

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();

    List<T> getAll();
}