package ru.job4j.oo2.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean flag = true;
            while (flag) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    Set<String> words = Set.of(str.split("[= ]+"));
                    if (words.contains("Hello")) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello, dear friend.".getBytes());
                    } else if (words.contains("Exit")) {
                        flag = false;
                    } else {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("What?".getBytes());
                    }
                    System.out.println(str);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
