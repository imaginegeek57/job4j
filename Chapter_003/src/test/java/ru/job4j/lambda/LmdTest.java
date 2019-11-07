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
        final List<Double> result = lmd.diapason(1, 5, index -> Math.pow(index, 3));
        List<Double> expected = Arrays.asList(1D, 8D, 27D, 64D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lmd function = new Lmd();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D); //
        assertThat(result, is(expected));
    }
    @Test
    public void addition() {
        Lmd func = new Lmd();
        final List<Double> diapason = func.diapason(3, 6, index -> 4 + index);
        List<Double> expected = Arrays.asList(7D, 8D, 9D);
        assertThat(diapason, is(expected));
    }
    @Test
    public void subtraction() {
        Lmd lmd = new Lmd();
        final List<Double> diapason = lmd.diapason(5, 9, index -> index - 4 );
        List<Double> expected = Arrays.asList(1D, 2D, 3D, 4D);
        assertThat(diapason, is(expected));
    }
}

