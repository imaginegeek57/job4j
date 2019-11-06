package ru.job4j.IOChat;

import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class SimpleChat {

    /**
     * Логгер
     */
    private static final Logger log = Logger.getLogger(String.valueOf(SimpleChat.class));

    /**
     * Стоп-слово
     */
    private static final String STOP_WORD = "stop";

    public static void main(String[] args) throws IOException {
        SimpleChat chat = new SimpleChat("randomList.txt");
        chat.run();
    }

    /**
     * Лог чата
     * Содержит переписку
     */
    private List <String> chatLog = new LinkedList <>();

    /**
     * Ответы из файла
     */
    private List <String> answers;

    /**
     * Получить случайный ответ
     *
     * @return ответ
     */
    private String getRandomAnswer() {
        return answers.get(ThreadLocalRandom.current().nextInt(answers.size()));
    }

    /**
     * Файл с ответами
     */
    private File answersFile;

    /**
     * Конструктор
     *
     * @param answersFilePath путь к файлу с ответами
     */
    public SimpleChat(String answersFilePath) throws IOException {
        this.answersFile = new File(answersFilePath);
        this.answers = readAnswersFromFile(this.answersFile);
    }

    /**
     * Чтение ответов из файла
     *
     * @param file файл с ответами
     * @return список ответов
     * @throws IOException исключение при чтении ответов из файла
     */
    private List <String> readAnswersFromFile(File file) throws IOException {
        List <String> list = new ArrayList <>();
        log.info("Reading file with answers");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ans;
            while (((ans = br.readLine()) != null) && !ans.trim().isEmpty()) {
                list.add(ans);
            }
            log.info(String.format("%d answers were found and loaded", list.size()));
        }
        return list;
    }

    /**
     * Запуск чата
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your message to start the chat:");

        String inputMessage = null;
        String outputMessage = null;
        do {

            inputMessage = scanner.nextLine();
            chatLog.add(inputMessage);

            outputMessage = getRandomAnswer();
            chatLog.add(outputMessage);
            System.out.println(outputMessage);

            System.out.println("Write your answer:");

        } while (!STOP_WORD.equalsIgnoreCase(inputMessage));
        scanner.close();

        log.info("выход из чата");

        System.out.println(chatLog);
    }

}


