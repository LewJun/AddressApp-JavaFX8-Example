package com.example.lewjun.address;

import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {

    public StringProperty firstName;
    public StringProperty lastName;
    public StringProperty street;
    public IntegerProperty postalCode;
    public StringProperty city;
    public ObjectProperty<LocalDate> birthday;

    public Person(final String firstName, final String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1999, 2, 21));
    }

}