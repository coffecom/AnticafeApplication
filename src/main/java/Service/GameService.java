package Service;

import DAL.Entity.GameEntity;
import DAL.Entity.RegularCustomersEntity;

import java.util.ArrayList;

public interface GameService extends Service<GameEntity> {
    ArrayList<String> getGenres();
    Integer getHoursByGenre(String genre);
}
