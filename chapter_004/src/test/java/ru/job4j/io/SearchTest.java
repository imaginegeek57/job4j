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
        String parent = "C:\\projects\\prfl";
        List <File> files = search.searchFiles(parent, Arrays.asList(".txt"));
        files.forEach(file -> System.out.println(file.getName()));
    }
}