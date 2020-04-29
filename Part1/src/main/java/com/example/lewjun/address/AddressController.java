package com.example.lewjun.address;

import com.example.lewjun.BaseController;
import com.example.lewjun.DateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author LewJun
 */
public class AddressController extends BaseController {
    /**
     * The data as an observable list of Persons.
     */
    private final ObservableList<Person> personData = FXCollections.observableArrayList();
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        super.initialize(location, resources);

        initPersonData();

        initPersonTable();

    }

    /**
     * 初始化PersonData
     */
    private void initPersonData() {
        personData.addAll(
                new Person("Hans", "Muster"),
                new Person("Ruth", "Mueller"),
                new Person("Heinz", "Kurz"),
                new Person("Cornelia", "Meier"),
                new Person("Werner", "Meyer"),
                new Person("Lydia", "Kunz"),
                new Person("Anna", "Best"),
                new Person("Stefan", "Meier"),
                new Person("Martin", "Mueller")
        );
    }

    /**
     * 初始化PersonTable
     */
    private void initPersonTable() {
        personTable.setItems(personData);

        // Clear person details.
        showPersonDetails(null);

        personTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

        initPersonTableColumns();
    }

    /**
     * 初始化PersonTable的列
     */
    private void initPersonTableColumns() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    /**
     * show Person Detail
     *
     * @param person Person
     */
    private void showPersonDetails(final Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
        }
    }

}
