package com.example.lewjun.address;

import com.example.lewjun.enums.EnumSex;
import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {
    private final ObjectProperty<UUID> uid;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    private final ObjectProperty<EnumSex> sex;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null);
    }


    public Person(final String firstName, final String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        uid = new SimpleObjectProperty<>(UUID.randomUUID());

        // Some initial dummy data, just for convenient testing.
        street = new SimpleStringProperty("some street");
        postalCode = new SimpleIntegerProperty(1234);
        city = new SimpleStringProperty("some city");
        birthday = new SimpleObjectProperty<>(LocalDate.of(1999, 2, 21));
        sex = new SimpleObjectProperty<>(EnumSex.MALE);
    }

    public UUID getUid() {
        return uid.get();
    }

    public ObjectProperty<UUID> uidProperty() {
        return uid;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(final String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(final String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(final String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(final int postalCode) {
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(final String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(final LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public EnumSex getSex() {
        return sex.get();
    }

    public void setSex(final EnumSex enumSex) {
        sex.set(enumSex);
    }
}