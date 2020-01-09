package ru.job4j.lambda;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.List;

public class ProfileTest {
    @Test
    public void checkListAddress() {
        Profile.Address address1 = new Profile.Address("A", "A1", 1, 1);
        Profile.Address address2 = new Profile.Address("B", "B2", 2, 2);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> profiles = List.of(profile1, profile2);
        List<Profile.Address> expected = List.of(address1, address2);
        List<Profile.Address> result = Profile.collect(profiles);
        assertThat(result, is(expected));
    }
}
