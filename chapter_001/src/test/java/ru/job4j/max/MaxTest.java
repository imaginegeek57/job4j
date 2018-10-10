
import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class MaxTest {


    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(2, 4);
        assertThat(result, is(2));
    }
}
