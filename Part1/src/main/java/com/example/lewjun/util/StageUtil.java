package com.example.lewjun.util;

import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * stage工具类
 *
 * @author LewJun
 */
public class StageUtil {
    /**
     * 关闭 stage
     *
     * @param object
     */
    public static void closeStage(final Object object) {
        if (object instanceof Control) {
            closeStage((Control) object);
        }
    }

    /**
     * 关闭 stage
     *
     * @param control
     */
    public static void closeStage(final Control control) {
        final Scene scene = control.getScene();
        if (scene == null) {
            return;
        }

        final Window window = scene.getWindow();

        if (window == null) {
            return;
        }
        final Stage stage = (Stage) window;
        stage.close();
    }
}
