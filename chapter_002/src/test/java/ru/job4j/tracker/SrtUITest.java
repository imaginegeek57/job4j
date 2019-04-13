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

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

      ...//

    @Test
    public void whenFindById() {
          Tracker tracker = new Tracker();
        new StartUI(new StubInput(4), tracker, output).init();
        String expected = output.accept("Find item by Id");
        assertThat(this.output.toString(), is(expected));
    }
}
