package ru.job4j.oo2.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            Boolean flag = true;
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    Set<String> words = Set.of(str.split("[= ]+"));
                    if (words.contains("Bye")) {
                        flag = false;
                    }
                    while (!(str).isEmpty()) {
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
