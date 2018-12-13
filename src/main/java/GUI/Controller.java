package GUI;

import DAL.DAO.EntityDAO;
import DAL.Entity.*;
import DAL.HibernateSessionFactory;
import GUI.Charts.Charts;
import GUI.Tables.*;
import Service.EntityService;
import Service.GameServiceImp;
import Service.RegularCustomerServiceImp;
import javafx.fxml.FXML;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import org.hibernate.SessionFactory;

public class Controller {
    @FXML
    public TabPane tabPane;
    @FXML
    public SplitPane anticafePane;
    @FXML
    public SplitPane gamePane;
    @FXML
    public SplitPane boxPane;
    @FXML
    public SplitPane currCustomersPane;
    @FXML
    public SplitPane customersPane;
    @FXML
    public SplitPane regularCustomersPane;
    @FXML
    public SplitPane charts;

    @FXML
    private void initialize(){
        initData();
    }

    @SuppressWarnings("unchecked")
    public void initData(){
        SessionFactory factory = HibernateSessionFactory.getSessionFactory();
        Charts chart = new Charts();

        charts.getItems().add(chart.getAnticafeStatBar(new EntityService<>(new EntityDAO<>(factory,AnticafeEntity.class))));
        charts.getItems().add(chart.getGenreAndMinutesPane(new GameServiceImp(new EntityDAO<>(factory, GameEntity.class))));
        charts.getItems().add(chart.getAgePieChart(new RegularCustomerServiceImp(new EntityDAO<>(factory,RegularCustomersEntity.class))));

        anticafePane.getItems().add(new AnticafeTableView(new EntityService<>(new EntityDAO<>(factory,AnticafeEntity.class))).getTableView());
        gamePane.getItems().add(new GameTableView(new EntityService<>(new EntityDAO<>(factory, GameEntity.class))).getTableView());
        currCustomersPane.getItems().add(new CurrentCustomersTableView(new EntityService<>(factory, CurrentCustomersEntity.class)).getTableView());
        boxPane.getItems().add(new BoxWithGameTableView(new EntityService<>(factory, BoxWithGameEntity.class)).getTableView());
        customersPane.getItems().add(new CustomerTableView(new EntityService<>(factory, CustomerEntity.class)).getTableView());
        regularCustomersPane.getItems().add(new RegularCustomersTableView(new EntityService<>(factory, RegularCustomersEntity.class)).getTableView());

        HibernateSessionFactory.closeSessionFactory();
    }
}
