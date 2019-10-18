package ru.job4j.IOChat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SimpleChat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input words: ");
        ArrayList <String> list = new ArrayList <>();
        String str = null;
        while ((str = scanner.nextLine()) != null) {
            if (str.equals("stop")) {
                break;
            }
            list.add(str);
        }
        readingAnswer();

        System.out.printf("words: %s \n", list.get(random()));
        scanner.close();
    }

    public static void readingAnswer() {
        ArrayList <String> list = new ArrayList <>();
        try (BufferedReader br = new BufferedReader(new FileReader("randomList.txt"))) {
            String str = null;
            while ((str = br.readLine()) != null) {
                list.add(str);
            }
            System.out.println(list.get(random()));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static int random() {
        Random random = new Random();
        int rnd = random.nextInt(6) + 1;
        return rnd;
    }
}


