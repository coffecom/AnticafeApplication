package DAL.DAO;

import java.util.List;

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