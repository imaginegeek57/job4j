package ru.job4j.IOChat;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class SimpleChat implements Runnable, Closeable {

    /**
     * Логгер
     */
    private static final Logger log = Logger.getLogger(String.valueOf(SimpleChat.class));

    /**
     * Стоп-слово
     */
    private static final String STOP_WORD = "stop";

    /**
     * Имя пользователя
     */
    private static final String USER_NAME = "Пользователь";

    /**
     * Имя бота
     */
    private static final String BOT_NAME = "Бот";

    /**
     * Формат даты и времени в названии файла
     */
    private static final DateTimeFormatter DATETIME_IN_FILENAME = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    /**
     * Формат даты и времени в логе чата
     */
    private static final DateTimeFormatter DATETIME_IN_CHAT_LOG = DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss");

    public static void main(String[] args) throws IOException {
        SimpleChat chat = new SimpleChat("randomList.txt");
        chat.run();
        chat.close();
    }

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
     * Запись лога в файл
     */
    private PrintWriter chatLogWriter;

    /**
     * Конструктор
     *
     * @param answersFilePath путь к файлу с ответами
     */
    public SimpleChat(String answersFilePath) throws IOException {
        this.answersFile = new File(answersFilePath);
        this.answers = readAnswersFromFile(this.answersFile);
        this.chatLogWriter = createChatLogWriter();
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
     * Создать запись лога чата в файл
     *
     * @return запись лога
     * @throws IOException исключение ввода/вывода
     */
    private PrintWriter createChatLogWriter() throws IOException {
        String fileName = String.format("%s_chat.log", LocalDateTime.now().format(DATETIME_IN_FILENAME));
        return new PrintWriter(fileName, StandardCharsets.UTF_8);
    }

    /**
     * Записать сообщение в лог
     *
     * @param name    автор
     * @param message сообщение
     */
    private void writeToChatLog(String name, String message) {
        this.chatLogWriter
                .printf("[%s] %s: %s\n", LocalDateTime.now().format(DATETIME_IN_CHAT_LOG), name, message)
                .flush();
    }

    /**
     * Запуск чата
     */
    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write your message to start the chat:");

        String inputMessage = null;
        String outputMessage = null;
        do {

            inputMessage = scanner.nextLine();
            writeToChatLog(USER_NAME, inputMessage);

            outputMessage = getRandomAnswer();
            writeToChatLog(BOT_NAME, outputMessage);
            System.out.println(outputMessage);

            System.out.println("Write your answer:");

        } while (!STOP_WORD.equalsIgnoreCase(inputMessage));
        scanner.close();

        log.info("выход из чата");

    }

    @Override
    public void close() {
        this.chatLogWriter.close();
    }

}


