package ru.job4j.IOChat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class SimpleChat {

    private static final Logger log = Logger.getLogger(String.valueOf(SimpleChat.class));
    private static List <String> logwriter = new ArrayList <>();

    public static List <String> answer() {
        List <String> list = new ArrayList <>();
        try (BufferedReader br = new BufferedReader(new FileReader("randomList.txt"))) {
            String ans = null;
            while ((ans = br.readLine()) != null) {
                list.add(ans);
            }
            log.info("ответы готовы!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int random() {
        Random random = new Random();
        int rnd = random.nextInt(6) + 1;
        return rnd;
    }

    public static void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input words: ");
        String text = null;
        do {
            text = scanner.nextLine();
            System.out.println("continue to chat taping");
            String response = answer().get(random());
            System.out.println(response);
            logwriter.add(text);
            logwriter.add(response);
        } while (!text.equals("stop"));
        log.info("выход из чата");
        System.out.println(logwriter);
        scanner.close();
    }

    public static void main(String[] args) {
        init();
    }
}


