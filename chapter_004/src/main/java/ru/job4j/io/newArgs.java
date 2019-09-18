package ru.job4j.io;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class newArgs {

    private final String path;

    public newArgs(final String path) {
        this.path = path;
    }

    public void directory(File path) {
        for (final File fileEntry : path.listFiles()) {
            if (fileEntry.isDirectory()) {
                directory(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }


    private List <String> exts(String parent) {
        List <String> exts = new ArrayList <String>();
        File dir = new File(parent);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                exts.remove(file.getName());
            }
        }
        return exts;
    }
}



