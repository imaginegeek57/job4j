package ru.job4j.io;

import java.io.*;

public class Analyze {

    private final String source = "path/source.txt";

    public void unavailable(String source, String target) {

        try (BufferedReader br = new BufferedReader(new FileReader(this.source))) {
            String s = null;
            while ((s = br.readLine()) != null) {


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
