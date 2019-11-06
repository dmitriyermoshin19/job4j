package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book skazki = new Book("Skazki", 100);
        Book rasskazi = new Book("Rasskazi", 200);
        Book komedii = new Book("Komedii", 300);
        Book code = new Book("Clean code", 10);

        Book[] books = new Book[4];
        books[0] = skazki;
        books[1] = rasskazi;
        books[2] = komedii;
        books[3] = code;

        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println("Replace i = 0 to i = 3.");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            System.out.println(b.getName() + " - " + b.getCount());
        }
        System.out.println("Shown only Clean code");
        for (int i = 0; i < books.length; i++) {
            Book b = books[i];
            if (b.getName().equals("Clean code")) {
                System.out.println(b.getName() + " - " + b.getCount());
                break;
            }
        }
    }
}
