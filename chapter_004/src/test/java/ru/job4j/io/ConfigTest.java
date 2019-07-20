package ru.job4j.io;

import org.junit.Test;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    private Config config = new Config(this.path);
    private final Map <String, String> values = new HashMap <String, String>();
    private String path = "path/app.properties.txt";

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
    @Test
    public void useTest() {
        config.load();
        String result = values.get("hibernate.dialect");
        assertThat(result, is("org.hibernate.dialect.PostgreSQLDialect"));
    }
}



