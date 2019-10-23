package ru.job4j.IOChat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.logging.Logger;

public class SimpleChat {

    private static final Logger log = Logger.getLogger(String.valueOf(SimpleChat.class));
    private static ArrayList <String> logwriter = new ArrayList <>();

    public static void main(String[] args) throws IOException {
        ArrayList <String> answer = new ArrayList <>();
        try (BufferedReader br = new BufferedReader(new FileReader("randomList.txt"))) {
            String ans = null;
            while ((ans = br.readLine()) != null) {
                answer.add(ans);
            }
            log.info("ответы готовы!");
            Scanner scanner = new Scanner(System.in);
            System.out.println("input words: ");
            String text = null;
            do {
                System.out.println("continue to chat taping");
                text = scanner.nextLine();
                String response = answer.get(random());
                System.out.println(response);
                logwriter.add(text);
                logwriter.add(response);
            } while (!text.equals("stop"));
            log.info("выход из чата");

            System.out.println(logwriter);

            scanner.close();
        }
    }

    public static int random() {
        Random random = new Random();
        int rnd = random.nextInt(6) + 1;
        return rnd;
    }
}


