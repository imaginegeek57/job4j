
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
    final String  menu =  "0. Add new item"
            + System.lineSeparator()
            + "1. Show all items"
            + System.lineSeparator()
            + "2. Edit item"
            + System.lineSeparator()
            + "3. Delete item"
            + System.lineSeparator()
            + "4. Find item by ID"
            + System.lineSeparator()
            + "5, Find item by name"
            + System.lineSeparator()
            + "6. Exit program"
            + System.lineSeparator();
    private final Consumer <String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);


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
        final Item item = tracker.findByName("name").get(0);// вот строка ожидания, как ни пытался ее добавить не получается
        StringBuilder sb = new StringBuilder(menu)
                .append(menu)
                .append(item);
        assertThat(this.output.toString(), is(sb));
    }
}
