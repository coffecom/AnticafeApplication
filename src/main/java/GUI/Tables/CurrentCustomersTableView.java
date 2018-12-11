package GUI.Tables;

import DAL.Entity.CurrentCustomersEntity;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CurrentCustomersTableView implements DataBaseTableView {
    private TableView<CurrentCustomersEntity> view;
    private ObservableList<CurrentCustomersEntity> list;
    private final Service<CurrentCustomersEntity> service;

    public CurrentCustomersTableView( Service<CurrentCustomersEntity> service) {
        this.service = service;
    }

    @Override
    public TableView getTableView() {
        initData();
        return view;
    }
    @SuppressWarnings("unchecked")
    private void initData(){
        view = new TableView<>();
        list = FXCollections.observableList(service.getAll());

        TableColumn<CurrentCustomersEntity, Integer> card = new TableColumn<>("Card number");
        TableColumn<CurrentCustomersEntity, Integer> idAnticafe = new TableColumn<>("Anticafe id");

        card.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        idAnticafe.setCellValueFactory(new PropertyValueFactory<>("idAnticafe"));

        view.setItems(list);
        view.getColumns().setAll(card,idAnticafe);
    }
}
