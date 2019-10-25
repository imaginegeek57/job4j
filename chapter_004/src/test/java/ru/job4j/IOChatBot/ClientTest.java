package ru.job4j.IOChatBot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {

    private static String LS = System.getProperty("line.separator");

    private void testServer(String input, String excepted) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.goClient();
        assertThat(out.toString(), is(excepted));
    }


    @Test
    public void whenAskAnswer() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenAskHello() throws IOException {
        this.testServer(
                Joiner.on(LS).join(
                        "hi",
                        "exit"
                ),
                String.format("Hi wise friend, I'm a speaker.%s%s", LS, LS));
    }

    @Test
    public void whenAskUnsupported() throws IOException {
        this.testServer(
                Joiner.on(LS).join(
                        "unsupported ask",
                        "exit"
                ),
                Joiner.on(LS).join(
                        "I don't get",
                        "",
                        ""
                )
        );
    }
}