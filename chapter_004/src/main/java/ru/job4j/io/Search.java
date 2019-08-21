package ru.job4j.io;

import org.apache.commons.io.FilenameUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Search {

    public static List <File> searchFiles(String parent, List <String> exts) throws IOException {
        List <String> fileList = new ArrayList <>();
        List <String> dirList = new ArrayList <>();
        parent = "C/projects/somethingElse/cats.txt";
        File file = new File(parent);
        if (file.isDirectory()) {
            for (File item : file.listFiles()) {
                if (item.isDirectory()) {
                    dirList.add(item.getName());
                } else {
                    fileList.add(item.getName());
                }
            }
        }
        return null;
    }
}
