package model.entities;

public class NotUniqueLoginException extends Exception {

    private String message;

    public NotUniqueLoginException() {
    }

    public NotUniqueLoginException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new Exception(message).toString();
    }
}
