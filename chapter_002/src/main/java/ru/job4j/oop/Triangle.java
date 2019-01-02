package ru.job4j.oop;


public class Triangle implements Shape {
        public String draw() {
            StringBuilder pic = new StringBuilder();
            pic.append("  ^  ").append(System.lineSeparator());
            pic.append(" ^ ^ ").append(System.lineSeparator());
            pic.append("^^^^^");
            return pic.toString();
    }
}
