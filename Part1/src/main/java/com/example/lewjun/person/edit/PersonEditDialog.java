package com.example.lewjun.person.edit;

import com.example.lewjun.BaseApp;
import javafx.stage.Stage;

/**
 * @author LewJun
 */
public class PersonEditDialog extends BaseApp {
    @Override
    public String getResName() {
        return "view.fxml";
    }

    @Override
    public void initStage(final Stage stage) {
        stage.setTitle("编辑");
    }
}
