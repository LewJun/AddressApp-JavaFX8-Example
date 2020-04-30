package com.example.lewjun;

import com.example.lewjun.util.EventBusUtil;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author LewJun
 */
public abstract class BaseController implements Initializable {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        // 将Controller注册到EventBus中
        EventBusUtil.register(this);
    }
}
