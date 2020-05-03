package com.example.lewjun.callback;

import com.example.lewjun.BaseController;

/**
 * 显示回调
 *
 * @param <T>
 */
public interface OnShowCallback<T extends BaseController> {
    /**
     * run
     *
     * @param controller BaseController
     */
    default void run(final T controller) {

    }
}