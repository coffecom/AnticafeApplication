package GUI.Charts;

import DAL.Entity.AnticafeEntity;
import DAL.Entity.BoxWithGameEntity;
import DAL.Entity.GameEntity;
import DAL.Entity.RegularCustomersEntity;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;
import Service.RegularCustomerService;
import Service.GameService;

import java.util.ArrayList;

public class Charts {

    public BarChart<String, Number> getAnticafeStatBar(Service<AnticafeEntity> anticafeService) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Anticafe");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Number of tables");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        for (AnticafeEntity entity : anticafeService.getAll()) {
            XYChart.Series<String, Number> tmpSeries = new XYChart.Series<>();
            tmpSeries.setName(entity.getId() + " : " + entity.getAddressOfCafe());
            tmpSeries.getData().add(new XYChart.Data<>("tables", entity.getNumberOfTables()));
            barChart.getData().add(tmpSeries);
        }
        return barChart;
    }

    public PieChart getAgePieChart(RegularCustomerService service) {
        int children = service.getValueOfChildren();
        int all = service.getAll().size();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Under 18: " + children, children),
                new PieChart.Data("Over 18: " + (all - children), all - children));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Age of clients");
        return chart;
    }

    public PieChart getGenreAndMinutesPane(GameService service) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (String genre : service.getGenres()) {
            pieChartData.add(new PieChart.Data(genre + ": " + service.getHoursByGenre(genre), service.getHoursByGenre(genre)));
        }

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Hours played");
        return pieChart;
    }

    public BarChart<String, Number> getGenreAndMinutesChart(GameService service) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Жанр");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Минуты");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setAnimated(false);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Сыграно минут");

        for (String genre : service.getGenres()) {
            series.getData().add(new XYChart.Data<>(genre, service.getHoursByGenre(genre)));
        }

        barChart.getData().add(series);
        return barChart;
    }
}