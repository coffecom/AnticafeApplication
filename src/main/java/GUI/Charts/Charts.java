package GUI.Charts;

import DAL.Entity.AnticafeEntity;
import DAL.Entity.BoxWithGameEntity;
import DAL.Entity.GameEntity;
import DAL.Entity.RegularCustomersEntity;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

import java.util.ArrayList;

public class Charts {

    public BarChart<String, Number> getAnticafeStatBar(Service<AnticafeEntity> anticafeService){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Anticafe");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of tables");

        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);

        for(AnticafeEntity entity: anticafeService.getAll()){
            XYChart.Series<String, Number> tmpSeries = new XYChart.Series<>();
            tmpSeries.setName(entity.getId()+" : "+entity.getAddressOfCafe());
            tmpSeries.getData().add(new XYChart.Data<>("tables", entity.getNumberOfTables()));
            barChart.getData().add(tmpSeries);
        }
        return barChart;
    }

    public PieChart getAgePieChart(Service<RegularCustomersEntity> service){
        int children = getValueOfChildren(service);
        int all = service.getAll().size();
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList(
                new PieChart.Data("Under 18: "+children, children),
                new PieChart.Data("Over 18: "+(all-children), all-children));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Age of clients");
        return chart;
    }
    private int getValueOfChildren(Service<RegularCustomersEntity> service){
        int children = 0;
        for(RegularCustomersEntity entity: service.getAll()){
            if(entity.getAge() < 18)
                children++;
        }
        return children;
    }

    public PieChart getGenreAndMinutesPane(Service<GameEntity> service){
        ObservableList<PieChart.Data> pieChartData =FXCollections.observableArrayList();

        for(String genre: getGenres(service)){
            pieChartData.add(new PieChart.Data(genre+": "+ getHoursByGenre(service, genre), getHoursByGenre(service, genre)));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Hours played");
        return pieChart;
    }
    public BarChart<String, Number> getGenreAndMinutesChart(Service<GameEntity> service){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Жанр");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Минуты");

        BarChart<String, Number> barChart = new BarChart<>(xAxis,yAxis);
        barChart.setAnimated(false);
        XYChart.Series<String,Number> series = new XYChart.Series<>();
        series.setName("Сыграно минут");

        for(String genre: getGenres(service)){
            series.getData().add(new XYChart.Data<>(genre, getHoursByGenre(service, genre)));
        }

        barChart.getData().add(series);
        return barChart;
    }
    private ArrayList<String> getGenres(Service<GameEntity> service){
        ArrayList<String> list = new ArrayList<>();
        for(GameEntity entity: service.getAll()){
            if(!list.contains(entity.getGenre())){
                list.add(entity.getGenre());
            }
        }
        return list;
    }
    private Integer getHoursByGenre(Service<GameEntity> service,String genre){
        int value = 0;
        for(GameEntity entity: service.getAll())
            if (entity.getGenre().equals(genre)) {
                value += entity.getMinutesPlayed();
            }
        return value;
    }
}
