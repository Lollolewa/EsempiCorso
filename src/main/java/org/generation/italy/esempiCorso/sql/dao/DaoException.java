package org.generation.italy.esempiCorso.sql.dao;

public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause); // la causa della DaoException è SQLException
    }
}
// aggiunto per testare una merge in git!!
