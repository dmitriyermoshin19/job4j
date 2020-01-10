package ru.job4j.lambda;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;

public class ProfileTest {
    @Test
    public void checkListAddress() {
        Address address1 = new Address("A", "A1", 1, 1);
        Address address2 = new Address("B", "B2", 2, 2);
        Address address3 = new Address("B", "B2", 2, 2);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        List<Profile> profiles = List.of(profile3, profile2, profile1);
        List<Address> expected = List.of(address1, address2);
        List<Address> result = Profile.collect(profiles);
        assertThat(result, is(expected));
    }
}
