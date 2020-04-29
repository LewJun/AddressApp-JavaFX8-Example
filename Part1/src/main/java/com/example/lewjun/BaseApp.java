package com.example.lewjun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author LewJun
 */
public abstract class BaseApp extends Application {

    /**
     * 显示并等待
     *
     * @param stage Stage
     * @throws Exception
     */
    public void showAndWait(final Stage stage) throws Exception {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        initScene(stage);
        stage.showAndWait();
    }

    /**
     * 显示并等待
     *
     * @throws Exception
     */
    public void showAndWait() throws Exception {
        showAndWait(newStage());
    }

    /**
     * 显示
     *
     * @throws Exception
     */
    public void show() throws Exception {
        show(newStage());
    }

    /**
     * 显示
     *
     * @param stage Stage
     * @throws Exception
     */
    public void show(final Stage stage) throws Exception {
        initScene(stage);
        stage.show();
    }

    private Stage newStage() {
        return new Stage();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        show(stage);
    }

    /**
     * 初始化Scene
     *
     * @param stage Stage
     * @throws IOException
     */
    private void initScene(final Stage stage) throws IOException {
        final Parent root = FXMLLoader.load(getClass().getResource(getResName()));

        initStage(stage);

        stage.setScene(new Scene(root));
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
