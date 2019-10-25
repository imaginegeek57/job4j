package ru.job4j.IOChatBot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void goClient() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String request = null;
        String response = null;
        do {
            System.out.println("Hello oracle");
            request = in.readLine();
            System.out.println(request);
            if ("hi".equals(request)) {
                out.println("Hi wise friend, I'm a speaker.");
                out.println();
            } else if (!("exit".equals(request))) {
                out.println("I don't get");
                out.println();
            }
        } while (!("exit".equals(request)));
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName("localhost"), 2257)) {
            new Client(socket);
        }
    }
}
