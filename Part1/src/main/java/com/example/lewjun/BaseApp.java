package com.example.lewjun;

import com.example.lewjun.callback.OnShowCallback;
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
    public void showModal(final Stage stage, final OnShowCallback callback) throws Exception {
        showModal(stage, null, false, callback);
    }

    /**
     * 显示模态框
     *
     * @throws Exception
     */
    public void showModal(final OnShowCallback callback) throws Exception {
        showModal(false, callback);
    }

    /**
     * 显示模态框
     *
     * @throws Exception
     */
    public void showModal(final String title, final OnShowCallback callback) throws Exception {
        showModal(title, false, callback);
    }

    public void showModal(final boolean wait, final OnShowCallback callback) throws Exception {
        showModal(newStage(), wait, callback);
    }

    public void showModal(final Stage stage, final boolean wait, final OnShowCallback callback) throws Exception {
        showModal(stage, null, wait, callback);
    }

    public void showModal(final String title, final boolean wait, final OnShowCallback callback) throws Exception {
        showModal(newStage(), title, wait, callback);
    }

    public void showModal(final Stage stage, final String title, final boolean wait,
                          final OnShowCallback callback) throws Exception {
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);

        show(stage, title, wait, callback);
    }


    /**
     * 显示
     *
     * @param stage Stage
     * @throws Exception
     */
    public void show(final Stage stage, final String title, final boolean wait,
                     final OnShowCallback callback) throws Exception {
        initScene(stage);
        setStageTitle(stage, title);

        if (wait) {
            stage.showAndWait();
        } else {
            stage.show();

            if (callback != null) {
                callback.run(getController());
            }
        }
    }

    private Stage newStage() {
        return new Stage();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        show(stage, null, false, null);
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

        root.getStylesheets().add("DarkTheme.css");

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
