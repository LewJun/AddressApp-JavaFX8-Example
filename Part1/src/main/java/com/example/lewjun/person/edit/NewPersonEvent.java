package com.example.lewjun.person.edit;

import com.example.lewjun.BaseEvent;
import com.example.lewjun.address.Person;

/**
 * 新增Person事件
 *
 * @author LewJun
 */
public class NewPersonEvent extends BaseEvent {
    private final transient Person person;

    NewPersonEvent(final Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
