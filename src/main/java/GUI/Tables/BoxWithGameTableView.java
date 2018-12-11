package GUI.Tables;

import DAL.Entity.BoxWithGameEntity;
import Service.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class BoxWithGameTableView implements DataBaseTableView {
    private TableView<BoxWithGameEntity> view;
    private ObservableList<BoxWithGameEntity> list;
    private Service<BoxWithGameEntity> service;

    public BoxWithGameTableView(Service<BoxWithGameEntity> service) {
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

        TableColumn<BoxWithGameEntity, Integer> id = new TableColumn<>("ID");
        TableColumn<BoxWithGameEntity, String> title = new TableColumn<>("Title");
        TableColumn<BoxWithGameEntity, Integer> condition = new TableColumn<>("Condition");
        TableColumn<BoxWithGameEntity, Date> date = new TableColumn<>("Date of purchase");
        TableColumn<BoxWithGameEntity, Integer> anticafeId = new TableColumn<>("Anticafe id");

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        condition.setCellValueFactory(new PropertyValueFactory<>("condition"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateOfPurchase"));
        anticafeId.setCellValueFactory(new PropertyValueFactory<>("anticafeId"));

        view.setItems(list);
        view.getColumns().setAll(id,title,condition,date,anticafeId);
    }
}
