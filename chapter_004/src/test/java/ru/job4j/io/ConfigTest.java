package ru.job4j.io;

import org.junit.Test;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void useTest() {
        Config config = new Config("path/app.properties.txt");
        config.load();
        String result = config.value("hibernate.dialect");
        assertThat(result, is("org.hibernate.dialect.PostgreSQLDialect"));
    }
}



