package ru.job4j.IOChat;

import java.util.Scanner;

public class SimpleChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input words: ");
        String words = scanner.nextLine();
        String str = null;
        while ((str = scanner.nextLine()) != null) {
            if (str.equals("stop")) {
                break;
            } else {
                continue;
            }
        }
        System.out.printf("words: %s \n", words);
        scanner.close();


    }
}


