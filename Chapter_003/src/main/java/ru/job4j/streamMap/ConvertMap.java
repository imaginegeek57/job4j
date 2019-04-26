package ru.job4j.streamMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMap {
    public Map <String, Student> convert(List <Student> con) {
        return con.stream().distinct().collect(
                Collectors.toMap(
                        Student -> Student.getSurname(),
                        Student -> Student
                ));
    }
}
