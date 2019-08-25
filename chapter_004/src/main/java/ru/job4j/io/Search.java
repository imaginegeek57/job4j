package ru.job4j.io;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Search {

    private List <File> search(String parent) {
        List <File> fileList = new ArrayList <>();
        Queue <File> dirList = new LinkedList <>();
        File file = new File(parent);
        if (file.isDirectory()) {
            dirList.add(file);
            while (!dirList.isEmpty()) {
                File f = dirList.poll();
                if (f.isDirectory()) {
                    dirList.addAll(Arrays.asList(f.listFiles()));
                } else {
                    fileList.add(f);
                }
            }
        }
        return fileList;
    }

    private List <String> exts(String parent) {
        List <String> exts = new ArrayList <String>();
        File dir = new File(parent);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                exts.add(file.getName());
            }
        }
        return exts;
    }

    public List <File> searchFiles(String parent, List <String> exts) {
        List <File> search = search(parent);
        exts.add(".txt");
        exts.add(".doc");
        FileFilter fileFilter = new WildcardFileFilter(exts);
        while (search.isEmpty() == false) {
            for (File f : search)
                search.addAll(Arrays.asList(f.listFiles(fileFilter)));
        }
        return search;
    }

    public static void main(String[] args) throws IOException {
        Search search = new Search();
        String property = System.getProperty("user.dir");
        List <File> files = search.searchFiles(property, Arrays.asList(".class"));
        files.forEach(file -> System.out.println(file.getName()));
    }
}
