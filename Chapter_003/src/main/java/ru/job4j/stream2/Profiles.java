package ru.job4j.stream2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Profiles {
    List<Address>collect(List<Profile>profiles) {
        return profiles.stream().map(profile -> profile.getAddress())
                .collect(Collectors.toList());

    }
}
