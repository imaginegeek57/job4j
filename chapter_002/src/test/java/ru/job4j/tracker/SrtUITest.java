
package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class SrtUITest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer <String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Before

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
        @Override
        public String toString() {
            return out.toString();
        }
    };
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(new String[] {"0","name", "desc", "n", "1", "y"}), tracker, output).init();
        final Item item = tracker.findByName("name").get(0);
        System.out.println(item);
        assertThat(this.output.toString(), is(item));
    }
}
