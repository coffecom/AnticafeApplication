package Service.Interfaces;

import java.util.List;

public interface Service<T, id> {
    T getGame(id id);

    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    void deleteAll();
}
