package com.example.lewjun.person.edit;

import com.example.lewjun.BaseController;
import com.example.lewjun.util.StageUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
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
    }

    /**
     * 处理btnCancel
     */
    private void handleBtnCancel() {
        btnCancel.setOnAction(event -> StageUtil.closeStage(event.getSource()));
    }
}
