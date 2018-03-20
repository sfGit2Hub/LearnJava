package org.mybatis.example;

import java.util.List;

/**
 * Created by SF on 2017/12/25.
 */
public class User {
    private long id;
    private String email;
    private String passport;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private Boolean married;
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public User setOrders(List<Order> orders) {
        this.orders = orders;
        return this;
    }

    public Boolean getMarried() {
        return married;
    }

    public User setMarried(Boolean married) {
        this.married = married;
        return this;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassport() {
        return passport;
    }

    public User setPassport(String passport) {
        this.passport = passport;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("email", email)
                .add("passport", passport)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("address", address)
                .add("city", city)
                .add("state", state)
                .add("phone", phone)
                .add("married", married)
                .toString();
    }
}
