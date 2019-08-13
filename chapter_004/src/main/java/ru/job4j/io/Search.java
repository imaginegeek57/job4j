package ru.job4j.io;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Search {

    public static List <File> searchFiles(String parent, List <String> exts) {

        exts = Arrays.asList(".txt");  // думаю здесь использовать lastIndexOf или FilenameUtils.getExtension или не верно думаю?

        File[] files = new File(parent).listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                List <File> loc = searchFiles(f.getPath(), exts);
                if (loc != null)
                    return loc;
            }
        }
        return null;
    }
}
