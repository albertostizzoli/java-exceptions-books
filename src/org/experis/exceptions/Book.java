package org.experis.exceptions;

public class Book {
    // Attributi
    private String title;
    private int pagesNumber;
    private String author;
    private String editor;

    // Costruttore
    public Book(String title, int pagesNumber, String author, String editor) {
        setTitle(title);
        setPagesNumber(pagesNumber);
        setAuthor(author);
        setEditor(editor);
    }

    // Metodi Get e Set con eccezioni più specifiche
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non deve essere vuoto");
        }
        this.title = title;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) throws IllegalArgumentException {
        if (pagesNumber <= 0) {
            throw new IllegalArgumentException("Il numero di pagine non deve essere minore o uguale a 0");
        }
        this.pagesNumber = pagesNumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author.isEmpty())  {
            throw new IllegalArgumentException("L'autore non deve essere vuoto");
        }
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) throws IllegalArgumentException {
        if (editor.isEmpty()) {
            throw new IllegalArgumentException("L'editore non deve essere vuoto");
        }
        this.editor = editor;
    }

    // Metodo per ottenere i dettagli del libro
    public String detailsBook() {
        return "Titolo: " + getTitle() + "\nNumero di pagine: " + getPagesNumber() + " \nAutore: " + getAuthor() + " \nEditore: " + getEditor();
    }

    @Override
    public String toString(){
        return "(Libro)\n" + detailsBook();
    }
}

