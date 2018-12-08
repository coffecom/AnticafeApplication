package GUI.Tables;

import DAL.Entity.AnticafeEntity;
import GUI.DataBaseTableView;
import Service.Implementations.EntityService;
import Service.Interfaces.Service;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnticafeTableView implements DataBaseTableView {
    private TableView<AnticafeEntity> view;
    private ObservableList<AnticafeEntity> list;
    private final Service<AnticafeEntity> service;
    public AnticafeTableView(Service<AnticafeEntity> service){
        this.service=service;
    }

    @SuppressWarnings("unchecked")
    private void initData(){
        view = new TableView<>();
        list = FXCollections.observableList(service.getAll());

        TableColumn<AnticafeEntity, Integer> anticafeId = new TableColumn<>("ID");
        TableColumn<AnticafeEntity, String> address = new TableColumn<>("Address");
        TableColumn<AnticafeEntity, Integer> numberOfTables = new TableColumn<>("Number of tables");
        TableColumn<AnticafeEntity, String> workingHours = new TableColumn<>("Working hours");

        anticafeId.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, Integer>("id"));
        address.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, String>("addressOfCafe"));
        numberOfTables.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, Integer>("numberOfTables"));
        workingHours.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, String>("workingHours"));

        view.setItems(list);
        view.getColumns().setAll(anticafeId,address,numberOfTables,workingHours);
    }
    @Override
    public TableView getTableView() {
        initData();
        return view;
    }
}
