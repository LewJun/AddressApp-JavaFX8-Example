package com.example.lewjun;

import com.google.common.eventbus.Subscribe;

public class SimpleListener {
    @Subscribe
    private void subscribeAction(String msg) {
        System.out.println(msg);
    }
}
