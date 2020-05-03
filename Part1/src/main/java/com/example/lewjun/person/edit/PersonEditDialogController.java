package com.example.lewjun.person.edit;

import com.example.lewjun.BaseController;
import com.example.lewjun.address.Person;
import com.example.lewjun.enums.EnumSex;
import com.example.lewjun.util.DateUtil;
import com.example.lewjun.util.EventBusUtil;
import com.example.lewjun.util.StageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Person编辑框控制器
 *
 * @author LewJun
 */
public class PersonEditDialogController extends BaseController {

    @FXML
    public ToggleGroup sexGroup;

    @FXML
    public RadioButton maleRadio;
    @FXML
    public RadioButton femaleRadio;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnOk;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField postalCodeField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField birthdayField;
    private Person editPerson;

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        super.initialize(location, resources);

        handleBtnCancel();

        handleBtnOk();
    }

    /**
     * 处理btnOk
     */
    private void handleBtnOk() {
        btnOk.setOnAction(event -> {
            final Person person = editPerson == null ? new Person() : editPerson;
            setPerson(person);
            if (editPerson != null) {
                // 使用EventBus发送消息
                EventBusUtil.post(new EditPersonEvent(person));
            } else {
                // 使用EventBus发送消息
                EventBusUtil.post(new NewPersonEvent(person));
            }

            StageUtil.closeStage(event.getSource());
        });
    }

    /**
     * 处理btnCancel
     */
    private void handleBtnCancel() {
        btnCancel.setOnAction(event -> StageUtil.closeStage(event.getSource()));
    }

    private void setPerson(final Person person) {
        person.setFirstName(firstNameField.getText());
        person.setLastName(lastNameField.getText());
        person.setStreet(streetField.getText());

        final String postalCodeText = postalCodeField.getText();
        Optional.ofNullable(postalCodeText).ifPresent(it -> {
            try {
                person.setPostalCode(Integer.parseInt(it));
            } catch (final Exception e) {
                logger.error("发生异常", e);
            }
        });
        person.setCity(cityField.getText());
        Optional.ofNullable(birthdayField.getText()).ifPresent(it -> {
            try {
                person.setBirthday(DateUtil.parse(it));
            } catch (final Exception e) {
                logger.error("发生异常", e);
            }
        });
        final Toggle selectedToggle = sexGroup.getSelectedToggle();

        final RadioButton sex = (RadioButton) selectedToggle;

        person.setSex(EnumSex.FEMALE.name().equalsIgnoreCase(sex.getText()) ? EnumSex.FEMALE : EnumSex.MALE);
    }

    public void showPersonEdit(final Person person) {
        editPerson = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        cityField.setText(person.getCity());
        postalCodeField.setText(String.valueOf(person.getPostalCode()));
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        sexGroup.selectToggle(person.getSex() == EnumSex.FEMALE ? femaleRadio : maleRadio);
    }
}
