package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            String strLine = null;
            while ((strLine = br.readLine()) != null) {
                if (strLine.equals("=")) {
                    String[] entry = strLine.split("=");
                    String k = entry[0];
                    String v = entry[1];
                    values.put(entry[0], entry[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

    public String value(String key) {
        String v = values.get(key);
        if (v == null) {
                throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return v;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("path/app.properties.txt"));
    }
}
