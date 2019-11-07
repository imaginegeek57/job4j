package ru.job4j.stream;
import java.util.stream.Collectors;
import java.util.*;
import java.util.function.Predicate;
import java.util.List;
public class School {
    List<Student> collect(List <Student> students, Predicate<Student>predict){
        List<Student> splitUp = students.stream().filter(predict)
        .collect(Collectors.toList());
        return splitUp;
    }
}
