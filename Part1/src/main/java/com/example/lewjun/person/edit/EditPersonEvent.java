package com.example.lewjun.person.edit;

import com.example.lewjun.BaseEvent;
import com.example.lewjun.address.Person;

/**
 * 编辑Person事件
 *
 * @author LewJun
 */
public class EditPersonEvent extends BaseEvent {
    private final transient Person person;

    EditPersonEvent(final Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}
