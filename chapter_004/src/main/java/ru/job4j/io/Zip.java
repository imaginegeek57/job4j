package ru.job4j.io;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private List <File> scan(String parent) {
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

    public List <File> seekBy(String root, String ext) {
        List <File> search = scan(root);
        FileFilter fileFilter = new WildcardFileFilter(ext);
        while (search.isEmpty() == true) {
            for (File f : search)
                search.addAll(Arrays.asList(f.listFiles(fileFilter)));
        }
        return search;
    }

    public void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Zip().pack(new File("./chapter_004/pom.xml"), new File("./chapter_004/pom.zip"));
    }
}