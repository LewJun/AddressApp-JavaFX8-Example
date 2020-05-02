package com.example.lewjun.address;

import com.example.lewjun.BaseController;
import com.example.lewjun.person.edit.NewPersonEvent;
import com.example.lewjun.person.edit.PersonEditDialog;
import com.example.lewjun.person.edit.PersonEditDialogController;
import com.example.lewjun.util.DateUtil;
import com.google.common.eventbus.Subscribe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author LewJun
 */
public class AddressController extends BaseController {
    private final ObservableList<Person> personData =
            FXCollections.observableArrayList();
    @FXML
    public Button btnDelPerson;
    @FXML
    public Button btnNewPerson;
    @FXML
    public Button btnEditPerson;
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

    private void newPerson() {
        btnNewPerson.setOnAction(event -> {
            try {
                final PersonEditDialog personEditDialog = new PersonEditDialog();
                personEditDialog.showModal(btnNewPerson.getText());
            } catch (final Exception e) {
                logger.error("出现异常", e);
            }
        });
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        super.initialize(location, resources);

        initPersonData();

        initPersonTable();

        deletePerson();

        newPerson();

        editPerson();
    }

    private void editPerson() {
        btnEditPerson.setOnAction(event -> {
            Person person =
                    personTable.getSelectionModel().getSelectedItem();

            PersonEditDialog personEditDialog = new PersonEditDialog();

            try {
                personEditDialog.show(btnEditPerson.getText());

                PersonEditDialogController personEditDialogController =
                        personEditDialog.getController();
                personEditDialogController.showPersonEdit(person);
            } catch (Exception e) {
                logger.error("发生异常", e);
            }
        });
    }

    /**
     * 订阅新增Person事件
     */
    @Subscribe
    private void subscribeNewPersonEvent(final NewPersonEvent newPersonEvent) {
        final Person person = newPersonEvent.getPerson();
        // 添加
        personData.add(person);
        // 选中所添加的数据
        personTable.getSelectionModel().select(person);
    }

    /**
     * 删除Person
     */
    private void deletePerson() {
        btnDelPerson.setOnAction(event -> {
            final int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                personTable.getItems().remove(selectedIndex);
            } else {
                // Nothing selected.
                final Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Selection");
                alert.setHeaderText("No Person Selected");
                alert.setContentText("Please select a person in the table.");

                alert.showAndWait();
            }
        });
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

        // 当列被选中的时候，右边显示详情
        personTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

        // 初始化PersonTable的列
        initPersonTableColumns();

        // 默认选中第一条数据
        personTable.getSelectionModel().selectFirst();
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
