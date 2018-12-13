package Service;

import DAL.DAO.DAO;
import DAL.Entity.GameEntity;
import DAL.Entity.RegularCustomersEntity;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class GameServiceImp extends EntityService<GameEntity> implements GameService {

    public GameServiceImp(DAO<GameEntity> dao) {
        super(dao);
    }

    public GameServiceImp(SessionFactory sessionFactory, Class<GameEntity> _class) {
        super(sessionFactory, _class);
    }

    @Override
    public ArrayList<String> getGenres() {
        ArrayList<String> list = new ArrayList<>();
        for (GameEntity entity : this.getAll()) {
            if (!list.contains(entity.getGenre())) {
                list.add(entity.getGenre());
            }
        }
        return list;
    }

    @Override
    public Integer getHoursByGenre(String genre) {
        int value = 0;
        for (GameEntity entity : this.getAll())
            if (entity.getGenre().equals(genre)) {
                value += entity.getMinutesPlayed();
            }
        return value;
    }
}
