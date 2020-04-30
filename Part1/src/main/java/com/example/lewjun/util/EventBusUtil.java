package com.example.lewjun.util;

import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * EventBus 工具类
 *
 * @author LewJun
 */
public class EventBusUtil {
    private static final Logger logger = LoggerFactory.getLogger(EventBusUtil.class);
    private static final EventBus EVENTBUS = new EventBus((throwable, context) -> {
        logger.info("【Event:{}】", Objects.toString(context.getEvent()));
        logger.info("【EventBus:{}】", Objects.toString(context.getEventBus()));
        logger.info("【Subscriber:{}】", Objects.toString(context.getSubscriber()));
        logger.info("【SubscriberMethod:{}】", Objects.toString(context.getSubscriberMethod()));

        logger.error("出现异常", throwable);
    });

    /**
     * 注册
     *
     * @param object
     */
    public static void register(final Object object) {
        EVENTBUS.register(object);
    }

    /**
     * 反注册
     *
     * @param object
     */
    public static void unregister(final Object object) {
        EVENTBUS.unregister(object);
    }

    /**
     * 发消息
     *
     * @param event
     */
    public static void post(final Object event) {
        EVENTBUS.post(event);
    }
}
