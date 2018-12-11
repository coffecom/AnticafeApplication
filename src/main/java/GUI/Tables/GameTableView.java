package GUI.Tables;

import DAL.Entity.GameEntity;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;

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
    @SuppressWarnings("unchecked")
    public BarChart getGenreAndMinutesChart(){
        final CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Genre");
        xAxis.setAnimated(false);

        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Minutes");
        yAxis.setAnimated(false);
        //xAxis.setTickLabelsVisible(true);

        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
        barChart.setAnimated(false);

        XYChart.Series<String, Number> series = new XYChart.Series();
        series.setName("Minutes played");

        for(String genre: getGenres()){
            series.getData().add(new XYChart.Data<String, Number>(genre, getHoursByGenre(genre)));
        }

        barChart.getData().add(series);
        return barChart;
    }
    private ArrayList<String> getGenres(){
        ArrayList<String> list = new ArrayList<>();
        for(GameEntity entity: service.getAll()){
            if(!list.contains(entity.getGenre())){
                list.add(entity.getGenre());
            }
        }
        return list;
    }
    private Integer getHoursByGenre(String genre){
        int value = 0;
        for(GameEntity entity: service.getAll())
            if (entity.getGenre().equals(genre)) {
                value += entity.getMinutesPlayed();
            }
        return value;
    }
}
