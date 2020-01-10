package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress)
                .distinct().sorted(new SortByCityAsc())
                .collect(Collectors.toList());
    }
}
