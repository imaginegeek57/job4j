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
            request = console.nextLine();
            out.println(request);
            if ("exit".equals(request)) {
                while (!(response = in.readLine()).isEmpty()) {
                    System.out.println(response);
                }
            }
        } while (!("exit".equals(request)));
    }

    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket(InetAddress.getByName("localhost"), 2257)) {
            new Client(socket);
        }
    }
}
