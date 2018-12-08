package GUI.Tables;

import DAL.Entity.RegularCustomersEntity;
import GUI.DataBaseTableView;
import Service.Implementations.EntityService;
import Service.Interfaces.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Timestamp;

public class RegularCustomersTableView implements DataBaseTableView {
    private TableView<RegularCustomersEntity> view;
    private ObservableList<RegularCustomersEntity> list;
    private final Service<RegularCustomersEntity> service;

    public RegularCustomersTableView(Service<RegularCustomersEntity> service) {
        this.service = service;
    }

    @Override
    public TableView getTableView() {
        initDate();
        return view;
    }
    @SuppressWarnings("unchecked")
    private void initDate(){
        view = new TableView<>();
        list = FXCollections.observableList(service.getAll());
        view.setItems(list);

        TableColumn<RegularCustomersEntity, Integer> cardNumber = new TableColumn<>("Card number");
        TableColumn<RegularCustomersEntity, String> customerName = new TableColumn<>("Name");
        TableColumn<RegularCustomersEntity, Timestamp> birthDate = new TableColumn<>("Birthday");
        TableColumn<RegularCustomersEntity, String> email = new TableColumn<>("E-mail");
        TableColumn<RegularCustomersEntity, String> phoneNumber = new TableColumn<>("Phone number");
        TableColumn<RegularCustomersEntity, Integer> minutesInCafe = new TableColumn<>("Minutes in cafe");
        TableColumn<RegularCustomersEntity, Integer> age = new TableColumn<>("Age");
        TableColumn<RegularCustomersEntity, Integer> discount = new TableColumn<>("Discount");

        cardNumber.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        birthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        minutesInCafe.setCellValueFactory(new PropertyValueFactory<>("minutesInCafe"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        discount.setCellValueFactory(new PropertyValueFactory<>("discount"));

        view.getColumns().setAll(cardNumber,customerName,birthDate,email,phoneNumber,minutesInCafe,age,discount);
    }
}
