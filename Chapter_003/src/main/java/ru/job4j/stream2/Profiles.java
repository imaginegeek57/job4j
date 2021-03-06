package ru.job4j.stream2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Profiles {
    List<Address>collect(List<Profile>profiles) {
        return profiles.stream().map(profile -> profile.getAddress())
        .sorted(Comparator.comparing(Address :: getCity)).distinct()
                .collect(Collectors.toList());
    }

}
