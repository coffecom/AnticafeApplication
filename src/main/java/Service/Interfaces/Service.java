package Service.Interfaces;

import java.util.List;

public interface Service<T> {
    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();

    /*void startTransaction();
    void commitTransacton();*/
}
