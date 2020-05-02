package com.example.lewjun.person.edit;

import com.example.lewjun.BaseController;
import com.example.lewjun.address.Person;
import com.example.lewjun.util.DateUtil;
import com.example.lewjun.util.EventBusUtil;
import com.example.lewjun.util.StageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
            final Person person = new Person();
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

            // 使用EventBus发送消息
            EventBusUtil.post(new NewPersonEvent(person));

            StageUtil.closeStage(event.getSource());
        });
    }

    /**
     * 处理btnCancel
     */
    private void handleBtnCancel() {
        btnCancel.setOnAction(event -> StageUtil.closeStage(event.getSource()));
    }

    public void showPersonEdit(Person person) {
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
    }
}
