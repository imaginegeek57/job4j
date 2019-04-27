package ru.job4j.streamMapTest;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import ru.job4j.streamMap.ConvertMap;
import ru.job4j.streamMap.Student;
import static org.hamcrest.Matchers.is;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;

public class StreamMapTest {
    @Test
    public void whenSomething() {
        ConvertMap convertMap = new ConvertMap();
        final Student student = new Student(50, "Pupkin", "Anchor");
        final Student student1 = new Student(60, "Pukin", "Bottom");
        final Student student2 = new Student(70,"Puck", "Ship");
        List<Student> list = Arrays.asList(student, student1, student2);
        final Map<String,Student> convert = convertMap.convert(list);
        Map<String, Student> ex = new HashMap <>();
        ex.put(student.getSurname(), student);
        ex.put(student1.getSurname(), student1);
        ex.put(student2.getSurname(), student2);
        assertThat(convert, is(ex));
    }
}
