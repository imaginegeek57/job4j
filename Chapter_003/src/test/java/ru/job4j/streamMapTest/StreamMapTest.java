package ru.job4j.streamMapTest;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import ru.job4j.StreamMap.ConvertMap;
import ru.job4j.StreamMap.Student;
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
        //List<Student> list = new Arrays.asList(student, student1, student2);  почему так не дает добавить в list?
        List<Student> list = new ArrayList <>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        Map<String, Student> go = new HashMap <>();
        convertMap.


    }

}
