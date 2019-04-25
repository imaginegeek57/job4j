package ru.job4j.StreamMap;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertMap {
    List<Student>convert(List<Student>con) {
        return con.stream().distinct().collect(
                Collectors.toMap(
                        Student -> Student.getSurname(), // это ключ карты по фамилии студента
                        Student -> Student// здесь должно быть значение Map но что-то оно не выходит

                );

        )
    }

}
