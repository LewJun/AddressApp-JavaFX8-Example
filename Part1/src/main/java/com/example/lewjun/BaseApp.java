package com.example.lewjun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author LewJun
 */
public abstract class BaseApp extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        final Parent root = FXMLLoader.load(getClass().getResource(getResName()));

        initStage(stage);

        stage.setScene(new Scene(root));

        stage.show();
    }

    /**
     * 返回布局文件的名称
     *
     * @return 返回布局文件的名称
     */
    public abstract String getResName();

    /**
     * 初始化stage
     *
     * @param stage Stage
     */
    public abstract void initStage(final Stage stage);
}
