package com.example.lewjun.address;

import com.example.lewjun.BaseApp;
import javafx.stage.Stage;

/**
 * @author LewJun
 */
public class AddressApp extends BaseApp {

    @Override
    public String getResName() {
        return "view.fxml";
    }

    @Override
    public void initStage(final Stage stage) {
        stage.setTitle("AddressApp");
    }

}
