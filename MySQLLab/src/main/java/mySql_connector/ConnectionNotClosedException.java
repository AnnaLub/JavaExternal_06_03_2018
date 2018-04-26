package mySql_connector;

public class ConnectionNotClosedException extends Exception {
    public ConnectionNotClosedException(String message) {
        super(message);
    }
}
