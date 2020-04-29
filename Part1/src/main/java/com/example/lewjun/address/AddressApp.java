package com.example.lewjun.address;

import com.example.lewjun.BaseApp;
import javafx.stage.Stage;

/**
 * @author LewJun
 */
public class AddressApp extends BaseApp {

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public String getResName() {
        return "view.fxml";
    }

    @Override
    public void initStage(final Stage stage) {
        stage.setTitle("AddressApp");
    }

}
