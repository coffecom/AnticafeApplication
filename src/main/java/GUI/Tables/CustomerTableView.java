package GUI.Tables;

import DAL.Entity.CustomerEntity;
import GUI.DataBaseTableView;
import Service.Interfaces.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.DatabaseMetaData;
import java.sql.Timestamp;

public class CustomerTableView implements DataBaseTableView {
    private TableView<CustomerEntity> view;
    private ObservableList<CustomerEntity> list;
    private final Service<CustomerEntity> service;

    public CustomerTableView(Service<CustomerEntity> service) {
        this.service = service;
    }

    @Override
    public TableView getTableView() {
        initData();
        return view;
    }

    private void initData() {
        list = FXCollections.observableList(service.getAll());
        view.setItems(list);

        TableColumn<CustomerEntity, Integer> card = new TableColumn<>("Card Number");
        TableColumn<CustomerEntity, Integer> table = new TableColumn<>("Table");
        TableColumn<CustomerEntity, Integer> payment = new TableColumn<>("Payment");
        TableColumn<CustomerEntity, Timestamp> registration = new TableColumn<>("Registration");
        TableColumn<CustomerEntity, Integer> gameId = new TableColumn<>("Id of game");

        card.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        table.setCellValueFactory(new PropertyValueFactory<>("currentTable"));
        payment.setCellValueFactory(new PropertyValueFactory<>("currentPayment"));
        registration.setCellValueFactory(new PropertyValueFactory<>("registrationTime"));
        gameId.setCellValueFactory(new PropertyValueFactory<>("idOfCurrentGame"));

        view.getColumns().setAll(card,table,payment,registration,gameId);
    }
}
