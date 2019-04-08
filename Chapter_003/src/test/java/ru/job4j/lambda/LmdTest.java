package ru.job4j.lambda;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class LmdTest {
    @Test
    public void name() {
        Lmd lmd= new Lmd();
        final List<Double> diapason = lmd.diapason(1, 5, index -> Math.pow(index, 3)); // после знака -> показывает ошибку
        diapason.forEach(System.out :: println);
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lmd function = new Lmd();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1); // аналогично  после знака -> показывает ошибку
        List<Double> expected = Arrays.asList(11D, 13D, 15D); //
        assertThat(result, is(expected));
    }
    @Test
    public void addition() {
        Lmd func = new Lmd();
        final List<Double> diapason = func.diapason(3, 6, index -> 4 + index);
        diapason.forEach(System.out :: println);
    }
    @Test
    public void subtraction() {
        Lmd lmd = new Lmd();
        final List<Double> diapason = lmd.diapason(5, 9, index -> index - 6 );
        diapason.forEach(System.out :: println);
    }
}