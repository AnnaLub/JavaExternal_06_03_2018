package mySql_connector;

public class ConnectionNotOpenedException extends Exception {
    public ConnectionNotOpenedException(String message) {
        super(message);
    }
}
