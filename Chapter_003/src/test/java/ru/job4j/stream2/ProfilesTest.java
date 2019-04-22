package ru.job4j.stream2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class ProfilesTest {
    @Test
    public void whenWeHaveTest() {
        Profiles profiles = new Profiles();
        final Address address = new Address("Moscow", "Lenin", 25, 2);
        final Profile profile = new Profile(address);
        List<Profile> str = Arrays.asList(profile);
        List<Address> cool = profiles.collect(str);
        assertThat(cool, is(Arrays.asList(address)));
    }
}
