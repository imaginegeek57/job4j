package ru.job4j.IOChat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class SimpleChat {

    public static void main(String[] args) throws IOException {
        ArrayList <String> answer = new ArrayList <>();
        try (BufferedReader br = new BufferedReader(new FileReader("randomList.txt"))) {
            String ans = null;
            while ((ans = br.readLine()) != null) {
                answer.add(ans);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("input words: ");
            ArrayList <String> list = new ArrayList <>();
            String text = null;
            do {
                System.out.println("continue to chat taping");
                text = scanner.nextLine();
                System.out.println(answer.get(random()));
            } while (!text.equals("stop"));
            list.add(text);
            scanner.close();
        }
    }

    public static int random() {
        Random random = new Random();
        int rnd = random.nextInt(6) + 1;
        return rnd;
    }
}


