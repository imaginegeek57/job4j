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
        try ( BufferedReader br = new BufferedReader(new FileReader(String.valueOf(values)))) {
            String strLine;
            while ((strLine = br.readLine()) != null)   {
                System.out.println (strLine);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    public String value(String key) {
        Map<String, String> values = new HashMap<String, String>();
        for (String i : values.keySet()) {
            if(i.equals(key)) {
                return key;
            }else
                throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return key;
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
        System.out.println(new Config("app.properties.txt"));
    }
}
