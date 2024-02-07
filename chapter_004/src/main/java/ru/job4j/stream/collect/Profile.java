package ru.job4j.stream.collect;

import ru.job4j.stream.SortByCityAsc;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private final Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress)
                .distinct().sorted(new SortByCityAsc())
                .collect(Collectors.toList());
    }
}
