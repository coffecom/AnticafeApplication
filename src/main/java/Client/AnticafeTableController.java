package Client;

import DAL.DAO.implementations.AnticafeDAOImplementation;
import DAL.Entity.AnticafeEntity;
import Service.Implementations.AnticafeServiceImplementation;
import Service.Interfaces.AnticafeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Observable;


public class AnticafeTableController {
    private ObservableList<AnticafeEntity> anticafeData = FXCollections.observableArrayList();
    @FXML
    private TableView<AnticafeEntity> tabableAnticafe;

    @FXML
    private TableColumn<AnticafeEntity, Integer> anticafeId;

    @FXML
    private TableColumn<AnticafeEntity, String> address;

    @FXML
    private TableColumn<AnticafeEntity, Integer> numberOfTables;

    @FXML
    private TableColumn<AnticafeEntity, String> workingHours;

    @FXML
    private void initialize(){
        initData();

        anticafeId.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, Integer>("id"));
        address.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, String>("addressOfCafe"));
        numberOfTables.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, Integer>("numberOfTables"));
        workingHours.setCellValueFactory(new PropertyValueFactory<AnticafeEntity, String>("workingHours"));

        tabableAnticafe.setItems(anticafeData);
    }

    private void initData(){
        AnticafeService service = new AnticafeServiceImplementation(new AnticafeDAOImplementation());
        anticafeData.addAll(service.getAll());
    }

}
