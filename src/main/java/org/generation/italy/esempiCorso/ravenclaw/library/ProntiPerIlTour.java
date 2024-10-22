package org.generation.italy.esempiCorso.ravenclaw.library;

public class ProntiPerIlTour {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();

        System.out.println(bookRepository.bookListByCategory(Category.ADVENTURE));
    }
}

