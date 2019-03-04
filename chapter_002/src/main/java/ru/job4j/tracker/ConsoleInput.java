package ru.job4j.tracker;
/**
 * @author Vlad Mon (imaginegeek57@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import java.util.*;
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
            if (!exist) {
                throw new MenuOutException("Out of menu range.");
            }
        return key;
    }
}
