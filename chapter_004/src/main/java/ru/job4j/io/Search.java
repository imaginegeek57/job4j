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

        parent = "C/projects/somethingElse/cats.txt"; //
        File[] files = new File(parent).listFiles(); //возвращает массив файлов и подкаталогов которы по пути parent
        for (File f : files) {   // проверяем в цикле все файлы и папки
            if (f.isDirectory()) { //если объект является каталогом то получаем его имя + обозначение
                System.out.println(f.getName() + "folder");
            } else {
                System.out.println(f.getName() + "file");  //если файл является каталогом то получаем его имя + обозначение
            }
        }
        return null;   // хотел сделать метод void но idea ругается, возращать ноль как-то тупо но умнее ничего не придумал)
    }
}
