package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    private List <File> exts(File dir, List <String> ext) {
        List <File> fileList = new ArrayList <>(scan(dir));
        List <File> fileList1 = new ArrayList <>(scan(dir));
        List <String> extsL = new ArrayList <>(ext);
        for (File file : fileList) {
            for (String i : extsL) {
                if (file.getName().endsWith((i))) {
                    fileList1.add(file);
                }
            }
        }
        return fileList1;
    }

    private List <File> scan(File file) {
        List <File> fileList = new ArrayList <>();
        Queue <File> dirList = new LinkedList <>();
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

    public void pack(File source, File target) {
        List <File> fileList = new ArrayList <>(exts(source, Arrays.asList(".txt")));
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(fileList.get(0).getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(fileList.get(0)))) {
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