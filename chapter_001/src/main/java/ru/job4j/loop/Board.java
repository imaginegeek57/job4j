package ru.job4j.loop;
/**
 * @author Vlad Mon
 * @version $Id$
 * @since 0.1
 */
public class Board {

        public String paint(int width, int height) {
            StringBuilder screen = new StringBuilder();
            String ln = System.lineSeparator();
            for (int j = 0; j < 3; j++) {
                for (int i = 0; i < 3; i++) {
                    if (i % 2 == 0) {
                        screen.append("X");
                    } else {
                        screen.append(" ");
                    }
                }
                screen.append(ln);
            }
            return screen.toString();
        }
    }
