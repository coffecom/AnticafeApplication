package GUI;

import DAL.DAO.implementations.EntityDAO;
import DAL.Entity.*;
import DAL.HibernateSessionFactory;
import GUI.Tables.*;
import Service.Implementations.EntityService;
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
    private void initialize(){
        initData();
    }
    
    @SuppressWarnings("unchecked")
    public void initData(){
        SessionFactory factory = HibernateSessionFactory.getSessionFactory();

        anticafePane.getItems().add(new AnticafeTableView(new EntityService<>(new EntityDAO<>(factory,AnticafeEntity.class))).getTableView());
        gamePane.getItems().add(new GameTableView(new EntityService<>(new EntityDAO<>(factory, GameEntity.class))).getTableView());
        currCustomersPane.getItems().add(new CurrentCustomersTableView(new EntityService<>(factory, CurrentCustomersEntity.class)).getTableView());
        boxPane.getItems().add(new BoxWithGameTableView(new EntityService<>(factory, BoxWithGameEntity.class)).getTableView());
        customersPane.getItems().add(new CustomerTableView(new EntityService<>(factory, CustomerEntity.class)).getTableView());
        regularCustomersPane.getItems().add(new RegularCustomersTableView(new EntityService<>(factory, RegularCustomersEntity.class)).getTableView());

        HibernateSessionFactory.closeSessionFactory();
    }
}
