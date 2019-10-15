package ru.job4j.IOChat;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input words: ");
        ArrayList<String> list = new ArrayList <>();
        String str = null;
        while ((str = scanner.nextLine()) != null) {
            if (str.equals("stop")) {
                break;
            }
            list.add(str);
        }
        System.out.printf("words: %s \n", list);
        scanner.close();

    }
}


