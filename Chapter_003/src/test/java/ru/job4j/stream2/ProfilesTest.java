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
        List<Profile> str = Arrays.asList(new Profile(new Address("Moscow", "Lenin", 25, 2)));
        List<Profile> cool = profiles.collect(profile -> profile.);  // небольшая проблемка в этом месте..

        assertThat(str, is(cool)); // как правильно написать ожидание ведь  str не должно совпадать с cool или должно?
    }
}
