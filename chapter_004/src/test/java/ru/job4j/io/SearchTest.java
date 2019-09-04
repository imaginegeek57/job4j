package ru.job4j.io;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchTest {

    @Test
    public void searchTest() {
        Search search = new Search();
        String property = System.getProperty("java.io.tmpdir");
        List <File> files = search.searchFiles(property, Arrays.asList(".class"));
        files.forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}