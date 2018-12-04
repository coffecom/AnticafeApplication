package DAL.DAO;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface DAO<T, ID> {
    Session openSession();

    Session openSessionWithTransaction();

    void closeSession();

    void closeSessionWithTransaction();

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();

    T getEntityById(ID id);

    List<T> getAll();

    // ArrayList<T> getSome(Predicate<T> predicate);
}