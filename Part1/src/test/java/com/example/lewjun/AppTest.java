package com.example.lewjun;

import com.google.common.eventbus.EventBus;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testApp() {
        Assert.assertTrue(true);

        SimpleListener listener = new SimpleListener();
        EventBus eventBus = new EventBus();
        eventBus.register(listener);
        eventBus.post("some text");

        eventBus.unregister(listener);
    }
}
