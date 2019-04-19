package ru.job4j.stream;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import ru.job4j.exemple.Calculator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenSplitUp() {
        School school = new School();
        List<Student> spl = Arrays.asList(new Student(100-70), new Student(70-50), new Student(50-0));
        school.collect(spl.stream().filter(student -> ()).collect(Collectors.toList())); // тут не совсем понимаю что написать
    }

}
