package ru.job4j.stream;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void whenSplitUp() {
        School school = new School();
        List<Student> spl = Arrays.asList(new Student(100), new Student(50), new Student(20), new Student(0));
        final List<Student>collect = school.collect(spl, student -> student.getScore() > 70);
        assertThat(collect, is(Arrays.asList(new Student(100))));
    }
    @Test
    public void whenSplitUp2() {
        School school = new School();
        List<Student> spl = Arrays.asList(new Student(100), new Student(50), new Student(20), new Student(0));
        final List<Student>collect = school.collect(spl, student -> student.getScore() < 70);
        assertThat(collect, is(Arrays.asList(new Student(50), new Student(20), new Student(0))));
    }
}
