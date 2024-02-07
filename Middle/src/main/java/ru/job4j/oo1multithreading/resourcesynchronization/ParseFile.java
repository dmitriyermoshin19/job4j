package ru.job4j.oo1multithreading.resourcesynchronization;

import java.io.*;
import java.nio.file.Files;

public class ParseFile {
        private File file;

        public synchronized void setFile(File f) {
            file = f;
        }

        public synchronized File getFile() {
            return file;
        }

        /**
         * Reading a file into a String.
         * @return file content as a string.
         * @throws IOException input / output exceptions.
         */
        public synchronized String getContent() throws IOException {
            return Files.readString(file.toPath());
        }

        /**
         * Reads only ASCII characters into a string.
         * @return a string containing only ASCII characters from a file.
         * @throws IOException input / output exception.
         */
        public synchronized String getContentWithoutUnicode() throws IOException {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                int data;
                while ((data = br.read()) > 0) {
                    if (data < 0x80) {
                        sb.append((char) data);
                    }
                }
            }
            return sb.toString();
        }

        /**
         * Writes a text string to a file.
         * @param content new content.
         * @throws IOException input / output exceptions.
         */
        public synchronized void saveContent(String content) throws IOException {
            Files.writeString(file.toPath(), content);
        }
}
