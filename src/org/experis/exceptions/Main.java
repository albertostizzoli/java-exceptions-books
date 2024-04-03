package org.experis.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Percorso del file per salvare i dati dei libri
    private static final String FILE_PATH = "C:\\MAMP\\htdocs\\esercizi\\java-exceptions-books\\resources\\data.txt";

    public static void main(String[] args) {
        // Utilizziamo un oggetto Scanner per leggere l'input dall'utente
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Quanti libri vuoi inserire? ");
            // Leggiamo il numero di libri da inserire
            int number = scanner.nextInt();
            scanner.nextLine(); // Consumiamo il newline
            Book[] books = new Book[number]; // Creiamo un array di libri
            int numBooks = 0; // Contatore per il numero di libri inseriti

            // Ciclo per inserire i libri
            while (numBooks < number) {
                System.out.println("Inserisci il titolo del libro");
                String title = scanner.nextLine();
                System.out.println("Inserisci il numero delle pagine");
                int pagesNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Inserisci il nome dell'autore");
                String author = scanner.nextLine();
                System.out.println("Inserisci il nome dell'editore");
                String editor = scanner.nextLine();

                // Prova a creare un nuovo libro con i dati inseriti
                try {
                    Book book = new Book(title, pagesNumber, author, editor);
                    books[numBooks++] = book; // Aggiungiamo il libro all'array
                } catch (IllegalArgumentException e) {
                    // Se ci sono problemi con i dati inseriti, gestiamo l'eccezione
                    System.out.println("Errore!");
                }
            }

            // Stampiamo i dettagli dei libri
            printBook(books);
            System.out.println("-----------------");
            // Leggiamo e stampiamo i dettagli dei libri salvati nel file
            readBook();
            System.out.println("Fine");
        }
    }

    // Metodo per stampare i dettagli dei libri nel file
    public static void printBook(Book[] books) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            // Iteriamo attraverso gli oggetti Book nell'array e scriviamo i loro dettagli nel file
            for (Book book : books) {
                writer.write(book + "\n");
            }
        } catch (IOException e) {
            // Gestiamo l'eccezione se si verifica un errore durante la scrittura nel file
            System.out.println("Errore nella scrittura del libro" + e.getMessage());
        }
    }

    // Metodo per leggere e stampare i dettagli dei libri dal file
    public static void readBook() {
        try (Scanner reader = new Scanner(new File(FILE_PATH))) {
            // Leggiamo e stampiamo ogni riga del file
            while (reader.hasNextLine()) {
                String str = reader.nextLine();
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            // Gestiamo l'eccezione se il file non viene trovato
            System.out.println("Errore nella lettura del libro\n" + e.getMessage());
        }
    }
}


