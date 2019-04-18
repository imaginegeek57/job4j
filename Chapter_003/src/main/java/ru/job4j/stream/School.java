package ru.job4j.stream;
import java.util.stream.Collectors;
import java.util.*;
import java.util.function.Predicate;
import java.util.List;

import java.util.stream.Collectors;
public class School {
    List<Student> collect(List <Student> students, Predicat<Student>predict){ // Predicat - это опечатка или в этом есть смысл?
        List<Student> classes = new LinkedList <>();
        List<Student> splitUp = classes.stream().filter(student -> student.score.contains(classes) // почему contains не работает?
        ).collect(Collectors.toList());
        return splitUp;
    }
}
