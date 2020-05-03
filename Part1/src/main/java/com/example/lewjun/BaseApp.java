package com.example.lewjun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author LewJun
 */
public abstract class BaseApp extends Application {

    protected static final Logger logger = LoggerFactory.getLogger(BaseApp.class);
    private FXMLLoader fxmlLoader;

    /**
     * 显示模态框
     *
     * @param stage Stage
     * @throws Exception
     */
    public void showModal(final Stage stage) throws Exception {
        showModal(stage, null, false);
    }

    /**
     * 显示模态框
     *
     * @throws Exception
     */
    public void showModal() throws Exception {
        showModal(false);
    }

    /**
     * 显示模态框
     *
     * @throws Exception
     */
    public void showModal(final String title) throws Exception {
        showModal(title, false);
    }

    public void showModal(final Stage stage, final boolean wait) throws Exception {
        showModal(stage, null, wait);
    }

    public void showModal(final boolean wait) throws Exception {
        showModal(newStage(), wait);
    }

    public void showModal(final String title, final boolean wait) throws Exception {
        showModal(newStage(), title, wait);
    }

    public void showModal(final Stage stage, final String title, final boolean wait) throws Exception {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        initScene(stage);

        setStageTitle(stage, title);

        if (wait) {
            stage.showAndWait();
        } else {
            stage.show();
        }
    }

    /**
     * 显示
     *
     * @throws Exception
     */
    public void show() throws Exception {
        show(newStage(), null);
    }

    /**
     * 显示
     *
     * @throws Exception
     */
    public void show(final String title) throws Exception {
        show(newStage(), title);
    }

    public void show(final Stage stage) throws Exception {
        show(stage, null);
    }

    /**
     * 显示
     *
     * @param stage Stage
     * @throws Exception
     */
    public void show(final Stage stage, final String title) throws Exception {
        initScene(stage);
        setStageTitle(stage, title);
        stage.show();
    }

    private Stage newStage() {
        return new Stage();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        show(stage, null);
    }

    private void setStageTitle(final Stage stage, final String title) {
        if (title != null) {
            stage.setTitle(title);
        }
    }

    /**
     * 初始化Scene
     *
     * @param stage Stage
     * @throws IOException
     */
    private void initScene(final Stage stage) throws IOException {
        fxmlLoader =
                new FXMLLoader(getClass().getResource(getResName()));

        final Parent root = fxmlLoader.load();

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

    public <T extends BaseController> T getController() {
        return fxmlLoader.getController();
    }
}
