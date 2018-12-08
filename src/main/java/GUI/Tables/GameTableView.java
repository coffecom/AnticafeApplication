package GUI.Tables;

import DAL.Entity.AnticafeEntity;
import DAL.Entity.GameEntity;
import GUI.DataBaseTableView;
import Service.Implementations.EntityService;
import Service.Interfaces.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GameTableView implements DataBaseTableView {
    private TableView<GameEntity> view;
    private ObservableList<GameEntity> list;
    private final Service<GameEntity> service;

    public GameTableView(Service<GameEntity> service) {
        this.service = service;
    }

    @Override
    public TableView getTableView() {
        initData();
        return view;
    }

    @SuppressWarnings("unchecked")
    private void initData() {
        view = new TableView<GameEntity>();
        list = FXCollections.observableList(service.getAll());

        TableColumn<GameEntity, String> title = new TableColumn<>("Title");
        TableColumn<GameEntity, String> genre = new TableColumn<>("Genre");
        TableColumn<GameEntity, Integer> age = new TableColumn<>("Age");
        TableColumn<GameEntity, Integer> difficulty = new TableColumn<>("Difficulty");
        TableColumn<GameEntity, String> popularity = new TableColumn<>("Popularity");
        TableColumn<GameEntity, String> notation = new TableColumn<>("Notation");
        TableColumn<GameEntity, Integer> cost = new TableColumn<>("Cost");
        TableColumn<GameEntity, Integer> minutes = new TableColumn<>("Minutes played");
        //TableColumn<GameEntity, Integer> quantity = new

        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        age.setCellValueFactory(new PropertyValueFactory<>("recomendedAge"));
        difficulty.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        popularity.setCellValueFactory(new PropertyValueFactory<>("popularity"));
        notation.setCellValueFactory(new PropertyValueFactory<>("notation"));
        cost.setCellValueFactory(new PropertyValueFactory<>("costOfMinute"));
        minutes.setCellValueFactory(new PropertyValueFactory<>("minutesPlayed"));

        view.setItems(list);
        view.getColumns().setAll(title, genre, age, difficulty, popularity, notation, cost, minutes);
    }
}
