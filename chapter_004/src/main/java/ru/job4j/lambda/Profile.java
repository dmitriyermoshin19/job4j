package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {

    public static class Address {
        private String city;
        private String street;
        private int home;
        private int apartment;

        public Address(String city, String street, int home, int apartment) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.apartment = apartment;
        }
    }

    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    static List<Profile.Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
