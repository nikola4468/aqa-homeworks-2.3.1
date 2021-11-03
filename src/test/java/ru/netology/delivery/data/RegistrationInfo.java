package ru.netology.delivery.data;

import lombok.Value;

@Value
public class RegistrationInfo {
    public RegistrationInfo(String city, String name, String phone) {
        this.city = city;
        this.name = name;
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    String city;
    String name;
    String phone;
}
